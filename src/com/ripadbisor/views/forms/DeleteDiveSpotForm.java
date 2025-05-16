/**
 * The DeleteDiveSpotForm class represents a JPanel that provides a user interface
 * for deleting diveSpots from a list. It displays a list of diveSpots with delete
 * buttons for each item, allowing users to remove diveSpots from the list. The class
 * also includes a success message label to provide feedback on the deletion operation.
 * 
 * Key Features:
 * - Displays a scrollable list of diveSpots with delete buttons.
 * - Allows users to delete a diveSpot by clicking the corresponding delete button.
 * - Shows a success or failure message after a deletion attempt.
 * - Includes a back button to navigate back to the main menu.
 * 
 * This class interacts with the MainFrame for navigation and the DiveSpotList model
 * to manage the list of diveSpots.
 */
package com.ripadbisor.views.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.DiveSpot;
import com.ripadbisor.models.DiveSpotList;
import com.ripadbisor.utils.UIUtils;
import com.ripadbisor.views.MainFrame;
import com.ripadbisor.views.components.BackButtonPanel;
import com.ripadbisor.views.components.DiveSpotPanel;

public class DeleteDiveSpotForm extends JPanel {
    private MainFrame mainFrame;
    private DiveSpotList diveSpotList;
    private JLabel successMessageLabel;
    private JPanel diveSpotListPanel;

    public DeleteDiveSpotForm(MainFrame mainFrame, DiveSpotList diveSpotList) {
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

    private void refreshDiveSpotList() {
        diveSpotListPanel.removeAll(); // Clear the panel before repopulating

        for (DiveSpot diveSpot : diveSpotList.getDiveSpots()) {
            JButton deleteButton = new JButton("❌");
            deleteButton.setForeground(Color.RED);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean removed = diveSpotList.removeDiveSpot(diveSpot.getName());
                    if (removed) {
                        successMessageLabel.setText("Successfully deleted: " + diveSpot.getName());
                        successMessageLabel.revalidate();
                        successMessageLabel.repaint();
                        refreshDiveSpotList();
                    } else {
                        successMessageLabel.setText("Failed to delete: " + diveSpot.getName());
                        successMessageLabel.setForeground(Color.RED);
                        successMessageLabel.revalidate();
                        successMessageLabel.repaint();
                    }
                }
            });

            // Use DiveSpotPanel to display the diveSpot
            DiveSpotPanel diveSpotPanel = new DiveSpotPanel(diveSpot, deleteButton);
            diveSpotListPanel.add(diveSpotPanel);
        }

        diveSpotListPanel.revalidate();
        diveSpotListPanel.repaint();
    }

}