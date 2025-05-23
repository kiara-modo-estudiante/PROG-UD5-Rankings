/**
 * The MainMenu class represents the main menu panel of the application.
 * It extends JPanel and provides a user interface with buttons for various
 * actions related to managing dive spots, such as adding, editing, showing,
 * and deleting dive spots. It also includes an option to exit the application.
 * 
 * Purpose:
 * - To serve as the main navigation menu for the application.
 * - To provide an intuitive interface for users to perform actions on dive spots.
 * - To handle user interactions and delegate actions to the MainFrame.
 */
package com.ripadbisor.views.panels;

import javax.swing.*;

import com.ripadbisor.views.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private MainFrame mainFrame;

    public MainMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new GridLayout(5, 1, 10, 10));

        // Button to add a new diveSpot
        JButton addButton = new JButton("🤿 Add new DiveSpot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddDiveSpotForm();
            }
        });
        add(addButton);

        // Button to edit an existing diveSpot
        JButton editButton = new JButton("📝 Edit existing DiveSpot");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showEditDiveSpotForm();
            }
        });
        add(editButton);

        // Show all diveSpots
        JButton showButton = new JButton("🔍 Show all DiveSpots");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAllDiveSpots();
            }
        });
        add(showButton);

        // Button to delete a diveSpot
        JButton deleteButton = new JButton("❌ Delete DiveSpot");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showDeleteDiveSpotForm();
            }
        });
        add(deleteButton);

        // Button to exit
        JButton exitButton = new JButton("👋 Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}