/**
 * The DeleteDivespotForm class represents a JPanel that provides a user interface
 * for deleting divespots from a list. It displays a list of divespots with delete
 * buttons for each item, allowing users to remove divespots from the list. The class
 * also includes a success message label to provide feedback on the deletion operation.
 * 
 * Key Features:
 * - Displays a scrollable list of divespots with delete buttons.
 * - Allows users to delete a divespot by clicking the corresponding delete button.
 * - Shows a success or failure message after a deletion attempt.
 * - Includes a back button to navigate back to the main menu.
 * 
 * This class interacts with the MainFrame for navigation and the DivespotList model
 * to manage the list of divespots.
 */
package com.ripadbisor.views.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.views.MainFrame;
import com.ripadbisor.views.components.BackButtonPanel;
import com.ripadbisor.views.components.DivespotPanel;

public class DeleteDivespotForm extends JPanel {
    private MainFrame mainFrame;
    private DivespotList divespotList;
    private JLabel successMessageLabel;
    private JPanel divespotListPanel;

    public DeleteDivespotForm(MainFrame mainFrame, DivespotList divespotList) {
        this.mainFrame = mainFrame;
        this.divespotList = divespotList;

        setLayout(new BorderLayout());

        // Top panel with back button
        add(new BackButtonPanel(e -> mainFrame.showMainMenu()), BorderLayout.NORTH);

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

    private void refreshDivespotList() {
        divespotListPanel.removeAll(); // Clear the panel before repopulating

        for (Divespot divespot : divespotList.getDivespots()) {
            JButton deleteButton = new JButton("❌");
            deleteButton.setForeground(Color.RED);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean removed = divespotList.removeDivespot(divespot.getName());
                    if (removed) {
                        successMessageLabel.setText("Successfully deleted: " + divespot.getName());
                        successMessageLabel.revalidate();
                        successMessageLabel.repaint();
                        refreshDivespotList();
                    } else {
                        successMessageLabel.setText("Failed to delete: " + divespot.getName());
                        successMessageLabel.setForeground(Color.RED);
                        successMessageLabel.revalidate();
                        successMessageLabel.repaint();
                    }
                }
            });

            // Use DivespotPanel to display the divespot
            DivespotPanel divespotPanel = new DivespotPanel(divespot, deleteButton);
            divespotListPanel.add(divespotPanel);
        }

        divespotListPanel.revalidate();
        divespotListPanel.repaint();
    }

}