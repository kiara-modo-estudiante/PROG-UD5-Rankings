package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private MainFrame mainFrame;

    public MainMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new GridLayout(5, 1, 10, 10));

        // Button to add a new divespot
        JButton addButton = new JButton("🤿 Add new Divespot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddDivespotForm();
            }
        });
        add(addButton);

        // Button to edit an existing divespot
        JButton editButton = new JButton("📝 Edit existing Divespot");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showEditDivespotForm();
            }
        });
        add(editButton);

        // Show all divespots
        JButton showButton = new JButton("🔍 Show all Divespots");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAllDivespots();
            }
        });
        add(showButton);

        // Button to delete a divespot
        JButton deleteButton = new JButton("❌ Delete Divespot");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showDeleteDivespotForm();
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