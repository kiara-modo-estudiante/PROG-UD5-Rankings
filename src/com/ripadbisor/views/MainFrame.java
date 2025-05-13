package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextArea displayArea;

    public MainFrame() {
        setTitle("Divespot Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    public void displayDivespotInfo(String info) {
        displayArea.append(info + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}