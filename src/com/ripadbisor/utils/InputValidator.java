/**
* Utility class for input validation, providing methods to parse integers and validate non-empty strings.
*/
package com.ripadbisor.utils;

import java.awt.Component;

public class InputValidator {

    /**
     * Parses a string to an integer.
     *
     * @param input       the string to parse
     * @param parentFrame the parent frame for the error dialog
     * @return the parsed integer
     * @throws NumberFormatException if the input is not a valid integer
     */
    public static int parseInt(String input, Component parentFrame) {
        return Integer.parseInt(input);
    }

    /**
     * Validates that a string is not empty.
     *
     * @param input       the string to validate
     * @param fieldName   the name of the field for the error message
     * @param parentFrame the parent frame for the error dialog
     * @return the trimmed input string
     * @throws IllegalArgumentException if the input is empty
     */
    public static String validateNotEmpty(String input, String fieldName, Component parentFrame) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("The field '" + fieldName + "' can't be empty.");
        }
        return input.trim();
    }

    /**
     * Validates that a diveSpot's rating is between 1 and 5.
     *
     * @param rating      the rating to validate
     * @param parentFrame the parent frame for the error dialog
     * @return the validated rating
     * @throws IllegalArgumentException if the rating is not between 1 and 5
     */
    public static int validateRating(int rating, Component parentFrame) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("The rating must be between 1 and 5.");
        }
        return rating;
    }

    /**
     * Validates that a diveSpot's depth is between 0 and 150.
     *
     * @param depth       the depth to validate
     * @param parentFrame the parent frame for the error dialog
     * @return the validated depth
     * @throws IllegalArgumentException if the depth is not between 0 and 150
     */
    public static int validateDepth(int depth, Component parentFrame) {
        if (depth < 0 || depth > 150) {
            throw new IllegalArgumentException("The depth must be between 0 and 150.");
        }
        return depth;
    }

    /**
     * Validates that the recommended season is Winter, Spring, Summer, or Autumn.
     *
     * @param season      the season to validate
     * @param parentFrame the parent frame for the error dialog
     * @return the validated season
     * @throws IllegalArgumentException if the season is not valid
     */
    public static String validateSeason(String season, Component parentFrame) {
        if (!season.equalsIgnoreCase("Winter") && !season.equalsIgnoreCase("Spring")
                && !season.equalsIgnoreCase("Summer") && !season.equalsIgnoreCase("Autumn")) {
            throw new IllegalArgumentException(
                    "The recommended season must be Winter, Spring, Summer or Autumn.");
        }
        return season;
    }

}
