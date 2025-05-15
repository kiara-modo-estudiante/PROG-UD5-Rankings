/**
 * The DivespotForm class represents a Swing-based form for adding new dive spots.
 * It provides a user interface for inputting details such as the name, location,
 * maximum depth, recommended season, presence of marine life, and rating of a dive spot.
 * 
 * This class interacts with the MainFrame to display information and uses the 
 * DivespotList to store the created dive spots. Input validation is performed 
 * using the InputValidator utility class to ensure data integrity.
 * 
 * The form includes a submit button that, when clicked, validates the input fields,
 * creates a new Divespot object, adds it to the DivespotList, and clears the form fields.
 */
package com.ripadbisor.views.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.utils.InputValidator;
import com.ripadbisor.views.MainFrame;

public class DivespotForm extends JPanel {
    // Form fields
    // These fields are used to collect user input for the divespot details.
    private JTextField nameField;
    private JTextField locationField;
    private JTextField maxDepthField;
    private JTextField seasonField;
    private JCheckBox marineLifeCheckBox;
    private JTextField ratingField;
    private JButton submitButton;
    private JLabel successMessageLabel;

    // References to the main frame and divespot list
    // These references are used to interact with the main application window and
    // the list of divespots.
    private MainFrame mainFrame;
    private DivespotList divespotList;

    public DivespotForm(MainFrame mainFrame, DivespotList divespotList) {
        // Constructor initializes the form and its components
        // It sets the layout, creates the input fields, and adds action listeners
        // to handle form submission.
        this.mainFrame = mainFrame;
        this.divespotList = divespotList;

        setLayout(new BorderLayout());

        // Top panel with back button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("← Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showMainMenu(); // Return to the main menu
            }
        });
        topPanel.add(backButton);
        add(topPanel, BorderLayout.NORTH);

        // Center panel with form fields
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        formPanel.add(locationField);

        formPanel.add(new JLabel("Max. depth:"));
        maxDepthField = new JTextField();
        formPanel.add(maxDepthField);

        formPanel.add(new JLabel("Recommended season:"));
        seasonField = new JTextField();
        formPanel.add(seasonField);

        formPanel.add(new JLabel("Is there marine life?"));
        marineLifeCheckBox = new JCheckBox();
        formPanel.add(marineLifeCheckBox);

        formPanel.add(new JLabel("Rating:"));
        ratingField = new JTextField();
        formPanel.add(ratingField);

        // Submit button to add the divespot
        // This button triggers the action to validate input and create a new divespot.
        submitButton = new JButton("Add Divespot");
        formPanel.add(submitButton);

        // Empty space for alignment
        formPanel.add(new JLabel(""));

        add(formPanel, BorderLayout.CENTER);

        // Bottom panel with success message
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        successMessageLabel = new JLabel(""); // Initially empty
        successMessageLabel.setForeground(new Color(0, 128, 0)); // Green color for success
        bottomPanel.add(successMessageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // It also displays the divespot information in the main frame and clears the
        // form fields.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = InputValidator.validateNotEmpty(nameField.getText(), "Name", mainFrame);
                    String location = InputValidator.validateNotEmpty(locationField.getText(), "Location", mainFrame);
                    int maxDepth = InputValidator.parseInt(maxDepthField.getText(), mainFrame);
                    String season = InputValidator.validateNotEmpty(seasonField.getText(), "Recommended season",
                            mainFrame);
                    boolean hasMarineLife = marineLifeCheckBox.isSelected();
                    int rating = InputValidator.parseInt(ratingField.getText(), mainFrame);

                    Divespot divespot = new Divespot(name, location, maxDepth, season, hasMarineLife, rating);
                    divespotList.addDivespot(divespot);

                    mainFrame.displayDivespotInfo(divespot.toString());

                    // Show success message
                    successMessageLabel.setText("You added a new divespot named: " + name);
                    successMessageLabel.revalidate();
                    successMessageLabel.repaint();

                    nameField.setText("");
                    locationField.setText("");
                    maxDepthField.setText("");
                    seasonField.setText("");
                    marineLifeCheckBox.setSelected(false);
                    ratingField.setText("");
                } catch (IllegalArgumentException ex) {
                    // Completed on InputValidator
                }
            }
        });
    }
}