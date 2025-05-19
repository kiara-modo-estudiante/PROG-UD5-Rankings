/**
 * Utility class for validating form inputs and creating a DiveSpot object.
 * 
 * This class provides a method to validate the input fields of a dive spot form,
 * ensuring that all required fields are properly filled and meet the expected
 * criteria. If validation is successful, it constructs and returns a DiveSpot
 * object with the validated data.
 */
package com.ripadbisor.utils;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.ripadbisor.models.DiveSpot;

public class FormValidator {
        /**
         * Validates the input fields of a dive spot form and creates a DiveSpot object.
         *
         * @param nameField          The text field for the dive spot name.
         * @param locationField      The text field for the dive spot location.
         * @param maxDepthField      The text field for the maximum depth.
         * @param seasonField        The text field for the diving season.
         * @param marineLifeCheckBox The checkbox indicating if marine life is present.
         * @param ratingField        The text field for the rating.
         * @param parentFrame        The parent component for error dialogs.
         * @return A DiveSpot object with validated data.
         */
        public static DiveSpot validateDiveSpotForm(JTextField nameField, JTextField locationField,
                        JTextField maxDepthField, JTextField seasonField,
                        JCheckBox marineLifeCheckBox, JTextField ratingField,
                        Component parentFrame) {

                // Validate each field and show error messages if necessary
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
