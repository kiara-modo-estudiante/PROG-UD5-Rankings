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

        setLayout(new GridLayout(7, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Location:"));
        locationField = new JTextField();
        add(locationField);

        add(new JLabel("Max. depth:"));
        maxDepthField = new JTextField();
        add(maxDepthField);

        add(new JLabel("Recommended season:"));
        seasonField = new JTextField();
        add(seasonField);

        add(new JLabel("Is there marine life?"));
        marineLifeCheckBox = new JCheckBox();
        add(marineLifeCheckBox);

        add(new JLabel("Rating:"));
        ratingField = new JTextField();
        add(ratingField);

        // Submit button to add the divespot
        // This button triggers the action to validate input and create a new divespot.
        submitButton = new JButton("Add Divespot");
        add(submitButton);

        // Action listener for the submit button
        // This listener handles the button click event, validates the input fields,
        // creates a new Divespot object, and adds it to the divespot list.
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