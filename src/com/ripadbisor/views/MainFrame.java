package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import com.ripadbisor.models.DivespotList;

public class MainFrame extends JFrame {
    private JTextArea displayArea;
    private DivespotList divespotList;

    public MainFrame() {
        setTitle("Divespot Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        divespotList = new DivespotList();
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