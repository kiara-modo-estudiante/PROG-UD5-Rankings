/**
 * Utility class for input validation, providing methods to parse integers and validate non-empty strings.
 */
package com.ripadbisor.utils;

import java.awt.Component;

import javax.swing.*;

public class InputValidator {

    /**
     * Parses a string to an integer, showing an error message if the input is
     * invalid.
     *
     * @param input       the string to parse
     * @param parentFrame the parent frame for the error dialog
     * @return the parsed integer
     * @throws NumberFormatException if the input is not a valid integer
     */
    public static int parseInt(String input, Component parentFrame) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentFrame, "Please, insert a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    /**
     * Validates that a string is not empty, showing an error message if it is.
     *
     * @param input       the string to validate
     * @param fieldName   the name of the field for the error message
     * @param parentFrame the parent frame for the error dialog
     * @return the trimmed input string
     * @throws IllegalArgumentException if the input is empty
     */
    public static String validateNotEmpty(String input, String fieldName, Component parentFrame) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "The field '" + fieldName + "' can't be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("The field '" + fieldName + "' can't be empty.");
        }
        return input.trim();
    }

    /**
     * Validates that a divespot's rating is between 1 and 5, showing an error
     * message if it is not.
     *
     * @param rating      the rating to validate
     * @param parentFrame the parent frame for the error dialog
     * @return the validated rating
     * @throws IllegalArgumentException if the rating is not between 1 and 5
     */
    public static int validateRating(int rating, Component parentFrame) {
        if (rating < 1 || rating > 5) {
            JOptionPane.showMessageDialog(parentFrame, "The rating must be between 1 and 5.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("The rating must be between 1 and 5.");
        }
        return rating;
    }
}