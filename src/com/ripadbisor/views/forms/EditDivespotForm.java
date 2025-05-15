/**
 * The EditDivespotForm class represents a Swing-based user interface panel
 * for editing and managing a list of divespots. It provides functionality
 * to display a list of divespots, edit their details, and update the list
 * dynamically. This form is part of a larger application and interacts with
 * the MainFrame and DivespotList classes.
 *
 * <p>Key Features:
 * - Displays a list of divespots with an option to edit each one.
 * - Provides a dialog-based form for editing divespot details.
 * - Updates the list dynamically after edits.
 * - Includes a success message display for user feedback.
 *
 * <p>Purpose:
 * This class is designed to allow users to manage and edit divespot information
 * in a user-friendly graphical interface, enhancing the overall usability of
 * the application.
 */
package com.ripadbisor.views.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.views.MainFrame;
import com.ripadbisor.views.components.DivespotPanel;

public class EditDivespotForm extends JPanel {
    private MainFrame mainFrame;
    private DivespotList divespotList;
    private JLabel successMessageLabel;
    private JPanel divespotListPanel;

    public EditDivespotForm(MainFrame mainFrame, DivespotList divespotList) {
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

        // Center panel to display the list of divespots
        divespotListPanel = new JPanel();
        divespotListPanel.setLayout(new BoxLayout(divespotListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(divespotListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel with success message
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        successMessageLabel = new JLabel(""); // Initially empty
        successMessageLabel.setForeground(new Color(0, 128, 0)); // Green color for success
        bottomPanel.add(successMessageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Populate the list of divespots
        refreshDivespotList();
    }

    /**
     * Refreshes the list of divespots displayed in the panel.
     * This method clears the existing divespot list and repopulates it
     * with the current divespots from the DivespotList model.
     */
    private void refreshDivespotList() {
        divespotListPanel.removeAll(); // Clear the panel before repopulating

        for (Divespot divespot : divespotList.getDivespots()) {
            JButton editButton = new JButton("📝");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showEditForm(divespot); // Open the edit form for the selected divespot
                }
            });

            // Use DivespotPanel to display the divespot
            DivespotPanel divespotPanel = new DivespotPanel(divespot, editButton);
            divespotListPanel.add(divespotPanel);
        }

        divespotListPanel.revalidate();
        divespotListPanel.repaint();
    }

    /**
     * Displays a dialog for editing the details of a selected divespot.
     * This method creates a new dialog with form fields pre-filled with
     * the current divespot information, allowing the user to edit and save changes.
     *
     * @param divespot The divespot to be edited.
     */
    private void showEditForm(Divespot divespot) {
        // Create a dialog for editing the divespot
        JDialog editDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Edit Divespot", true);
        editDialog.setSize(400, 300);
        editDialog.setLayout(new BorderLayout());

        // Form fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField nameField = new JTextField(divespot.getName());
        JTextField locationField = new JTextField(divespot.getLocation());
        JTextField maxDepthField = new JTextField(String.valueOf(divespot.getMaxDepth()));
        JTextField seasonField = new JTextField(divespot.getRecommendedSeason());
        JCheckBox marineLifeCheckBox = new JCheckBox("Marine Life", divespot.isHasMarineLife());
        JTextField ratingField = new JTextField(String.valueOf(divespot.getRating()));

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
                    // Update the divespot with new values
                    divespot.setName(nameField.getText());
                    divespot.setLocation(locationField.getText());
                    divespot.setMaxDepth(Integer.parseInt(maxDepthField.getText()));
                    divespot.setRecommendedSeason(seasonField.getText());
                    divespot.setHasMarineLife(marineLifeCheckBox.isSelected());
                    divespot.setRating(Integer.parseInt(ratingField.getText()));

                    successMessageLabel.setText("Successfully updated: " + divespot.getName());
                    successMessageLabel.revalidate();
                    successMessageLabel.repaint();

                    refreshDivespotList(); // Refresh the list after editing
                    editDialog.dispose(); // Close the dialog
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(editDialog, "Invalid input: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        editDialog.add(buttonPanel, BorderLayout.SOUTH);

        editDialog.setVisible(true);
    }
}