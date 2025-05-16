/**
 * The EditDiveSpotForm class represents a Swing-based user interface panel
 * for editing and managing a list of diveSpots. It provides functionality
 * to display a list of diveSpots, edit their details, and update the list
 * dynamically. This form is part of a larger application and interacts with
 * the MainFrame and DiveSpotList classes.
 *
 * <p>Key Features:
 * - Displays a list of diveSpots with an option to edit each one.
 * - Provides a dialog-based form for editing diveSpot details.
 * - Updates the list dynamically after edits.
 * - Includes a success message display for user feedback.
 *
 * <p>Purpose:
 * This class is designed to allow users to manage and edit diveSpot information
 * in a user-friendly graphical interface, enhancing the overall usability of
 * the application.
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
import com.ripadbisor.views.components.DiveSpotPanel;

public class EditDiveSpotForm extends JPanel {
    private MainFrame mainFrame;
    private DiveSpotList diveSpotList;
    private JLabel successMessageLabel;
    private JPanel diveSpotListPanel;

    public EditDiveSpotForm(MainFrame mainFrame, DiveSpotList diveSpotList) {
        this.mainFrame = mainFrame;
        this.diveSpotList = diveSpotList;

        setLayout(new BorderLayout());

        // Top panel with back button
        add(new BackButtonPanel(e -> mainFrame.showMainMenu()), BorderLayout.NORTH);

        // Center panel to display the list of diveSpots
        diveSpotListPanel = new JPanel();
        add(UIUtils.createScrollablePanel(diveSpotListPanel), BorderLayout.CENTER);

        // Bottom panel with success message
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        successMessageLabel = new JLabel(""); // Initially empty
        successMessageLabel.setForeground(new Color(0, 128, 0)); // Green color for success
        bottomPanel.add(successMessageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Populate the list of diveSpots
        refreshDiveSpotList();
    }

    /**
     * Refreshes the list of diveSpots displayed in the panel.
     * This method clears the existing diveSpot list and repopulates it
     * with the current diveSpots from the DiveSpotList model.
     */
    private void refreshDiveSpotList() {
        diveSpotListPanel.removeAll(); // Clear the panel before repopulating

        for (DiveSpot diveSpot : diveSpotList.getDiveSpots()) {
            JButton editButton = new JButton("📝");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showEditForm(diveSpot); // Open the edit form for the selected diveSpot
                }
            });

            // Use DiveSpotPanel to display the diveSpot
            DiveSpotPanel diveSpotPanel = new DiveSpotPanel(diveSpot, editButton);
            diveSpotListPanel.add(diveSpotPanel);
        }

        diveSpotListPanel.revalidate();
        diveSpotListPanel.repaint();
    }

    /**
     * Displays a dialog for editing the details of a selected diveSpot.
     * This method creates a new dialog with form fields pre-filled with
     * the current diveSpot information, allowing the user to edit and save changes.
     *
     * @param diveSpot The diveSpot to be edited.
     */
    private void showEditForm(DiveSpot diveSpot) {
        // Create a dialog for editing the diveSpot
        JDialog editDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Edit DiveSpot", true);
        editDialog.setSize(400, 300);
        editDialog.setLayout(new BorderLayout());

        // Form fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField nameField = new JTextField(diveSpot.getName());
        JTextField locationField = new JTextField(diveSpot.getLocation());
        JTextField maxDepthField = new JTextField(String.valueOf(diveSpot.getMaxDepth()));
        JTextField seasonField = new JTextField(diveSpot.getRecommendedSeason());
        JCheckBox marineLifeCheckBox = new JCheckBox("Marine Life", diveSpot.isHasMarineLife());
        JTextField ratingField = new JTextField(String.valueOf(diveSpot.getRating()));

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Location:"));
        formPanel.add(locationField);
        formPanel.add(new JLabel("Max Depth:"));
        formPanel.add(maxDepthField);
        formPanel.add(new JLabel("Season:"));
        formPanel.add(seasonField);
        formPanel.add(new JLabel("Marine Life:"));
        formPanel.add(marineLifeCheckBox);
        formPanel.add(new JLabel("Rating:"));
        formPanel.add(ratingField);

        editDialog.add(formPanel, BorderLayout.CENTER);

        // Save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validate inputs using InputValidator
                    String name = InputValidator.validateNotEmpty(nameField.getText(), "Name", editDialog);
                    String location = InputValidator.validateNotEmpty(locationField.getText(), "Location", editDialog);
                    int maxDepth = InputValidator.parseInt(maxDepthField.getText(), editDialog);
                    String season = InputValidator.validateNotEmpty(seasonField.getText(), "Season", editDialog);
                    boolean hasMarineLife = marineLifeCheckBox.isSelected();
                    int rating = InputValidator.parseInt(ratingField.getText(), editDialog);

                    // Validate that the rating is between 1 and 5
                    rating = InputValidator.validateRating(rating, editDialog);

                    // Update the diveSpot with validated values
                    diveSpot.setName(name);
                    diveSpot.setLocation(location);
                    diveSpot.setMaxDepth(maxDepth);
                    diveSpot.setRecommendedSeason(season);
                    diveSpot.setHasMarineLife(hasMarineLife);
                    diveSpot.setRating(rating);

                    successMessageLabel.setText("Successfully updated: " + diveSpot.getName());
                    successMessageLabel.revalidate();
                    successMessageLabel.repaint();

                    refreshDiveSpotList(); // Refresh the list after editing
                    editDialog.dispose(); // Close the dialog
                } catch (IllegalArgumentException ex) {
                    // Logic on Input Validator class
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        editDialog.add(buttonPanel, BorderLayout.SOUTH);

        editDialog.setVisible(true);
    }
}