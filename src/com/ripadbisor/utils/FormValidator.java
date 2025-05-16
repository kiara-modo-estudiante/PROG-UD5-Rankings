package com.ripadbisor.utils;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.ripadbisor.models.DiveSpot;

public class FormValidator {
    public static DiveSpot validateDiveSpotForm(JTextField nameField, JTextField locationField,
            JTextField maxDepthField, JTextField seasonField,
            JCheckBox marineLifeCheckBox, JTextField ratingField,
            Component parentFrame) {
        String name = InputValidator.validateNotEmpty(nameField.getText(), "Name", parentFrame);
        String location = InputValidator.validateNotEmpty(locationField.getText(), "Location", parentFrame);
        int maxDepth = InputValidator.parseInt(maxDepthField.getText(), parentFrame);
        maxDepth = InputValidator.validateDepth(InputValidator.parseInt(maxDepthField.getText(), parentFrame),
                parentFrame);
        String season = InputValidator.validateNotEmpty(seasonField.getText(), "Season", parentFrame);
        season = InputValidator.validateSeason(seasonField.getText(), parentFrame);
        boolean hasMarineLife = marineLifeCheckBox.isSelected();
        int rating = InputValidator.parseInt(ratingField.getText(), parentFrame);
        rating = InputValidator.validateRating(InputValidator.parseInt(ratingField.getText(), parentFrame),
                parentFrame);

        return new DiveSpot(name, location, maxDepth, season, hasMarineLife, rating);
    }
}
