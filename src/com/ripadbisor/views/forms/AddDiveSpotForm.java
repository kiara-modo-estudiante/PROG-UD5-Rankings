/**
 * The DiveSpotForm class represents a Swing-based form for adding new dive spots.
 * It provides a user interface for inputting details such as the name, location,
 * maximum depth, recommended season, presence of marine life, and rating of a dive spot.
 * 
 * This class interacts with the MainFrame to display information and uses the 
 * DiveSpotList to store the created dive spots. Input validation is performed 
 * using the InputValidator utility class to ensure data integrity.
 * 
 * The form includes a submit button that, when clicked, validates the input fields,
 * creates a new DiveSpot object, adds it to the DiveSpotList, and clears the form fields.
 */
package com.ripadbisor.views.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.DiveSpot;
import com.ripadbisor.models.DiveSpotList;
import com.ripadbisor.utils.InputValidator;
import com.ripadbisor.utils.UIUtils;
import com.ripadbisor.views.MainFrame;
import com.ripadbisor.views.components.BackButtonPanel;

public class AddDiveSpotForm extends JPanel {
    // Form fields
    // These fields are used to collect user input for the diveSpot details.
    private JTextField nameField;
    private JTextField locationField;
    private JTextField maxDepthField;
    private JTextField seasonField;
    private JCheckBox marineLifeCheckBox;
    private JTextField ratingField;
    private JButton submitButton;
    private JLabel successMessageLabel;

    // References to the main frame and diveSpot list
    // These references are used to interact with the main application window and
    // the list of diveSpots.
    private MainFrame mainFrame;
    private DiveSpotList diveSpotList;

    public AddDiveSpotForm(MainFrame mainFrame, DiveSpotList diveSpotList) {
        // Constructor initializes the form and its components
        // It sets the layout, creates the input fields, and adds action listeners
        // to handle form submission.
        this.mainFrame = mainFrame;
        this.diveSpotList = diveSpotList;

        setLayout(new BorderLayout());

        // Top panel with back button
        add(new BackButtonPanel(e -> mainFrame.showMainMenu()), BorderLayout.NORTH);

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

        // Submit button to add the diveSpot
        // This button triggers the action to validate input and create a new diveSpot.
        submitButton = new JButton("Add DiveSpot");
        formPanel.add(submitButton);

        // Empty space for alignment
        formPanel.add(new JLabel(""));

        add(formPanel, BorderLayout.CENTER);

        // Bottom panel with success message
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        successMessageLabel = UIUtils.createMessageLabel(new Color(0, 128, 0));
        bottomPanel.add(successMessageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Modify the submit button action listener to validate the rating range
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

                    // Validate that the rating is between 1 and 5
                    rating = InputValidator.validateRating(rating, mainFrame);

                    DiveSpot diveSpot = new DiveSpot(name, location, maxDepth, season, hasMarineLife, rating);
                    diveSpotList.addDiveSpot(diveSpot);

                    mainFrame.displayDiveSpotInfo(diveSpot.toString());

                    // Show success message
                    successMessageLabel.setText("You added a new diveSpot named: " + name);
                    successMessageLabel.revalidate();
                    successMessageLabel.repaint();

                    nameField.setText("");
                    locationField.setText("");
                    maxDepthField.setText("");
                    seasonField.setText("");
                    marineLifeCheckBox.setSelected(false);
                    ratingField.setText("");
                } catch (IllegalArgumentException ex) {
                    // Logic on Input Validator class
                }
            }
        });
    }
}
