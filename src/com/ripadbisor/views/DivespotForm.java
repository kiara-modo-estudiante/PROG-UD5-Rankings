package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;

public class DivespotForm extends JPanel {
    private JTextField nameField;
    private JTextField locationField;
    private JTextField maxDepthField;
    private JTextField seasonField;
    private JCheckBox marineLifeCheckBox;
    private JTextField ratingField;
    private JButton submitButton;

    public DivespotForm() {
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

        add(new JLabel("Has marine life:"));
        marineLifeCheckBox = new JCheckBox();
        add(marineLifeCheckBox);

        add(new JLabel("Rating:"));
        ratingField = new JTextField();
        add(ratingField);

        submitButton = new JButton("Add Divespot");
        add(submitButton);
    }
}