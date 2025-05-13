package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.utils.InputValidator;

public class DivespotForm extends JPanel {
    private JTextField nameField;
    private JTextField locationField;
    private JTextField maxDepthField;
    private JTextField seasonField;
    private JCheckBox marineLifeCheckBox;
    private JTextField ratingField;
    private JButton submitButton;

    private MainFrame mainFrame;
    private DivespotList divespotList;

    public DivespotForm(MainFrame mainFrame, DivespotList divespotList) {
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

        submitButton = new JButton("Add Divespot");
        add(submitButton);

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

                    String info = String.format(
                            "Name: %s\nLocation: %s\nMax. depth: %d\nRecommended season: %s\nIs there marine life?: %s\nRating: %d\n",
                            name, location, maxDepth, season, hasMarineLife ? "Yes" : "No", rating);
                    mainFrame.displayDivespotInfo(info);

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