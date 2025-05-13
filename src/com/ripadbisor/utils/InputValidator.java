package com.ripadbisor.utils;

import javax.swing.*;

public class InputValidator {

    public static int parseInt(String input, JFrame parentFrame) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentFrame, "Please, insert a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    public static String validateNotEmpty(String input, String fieldName, JFrame parentFrame) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "The field '" + fieldName + "' can't be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("The field '" + fieldName + "' can't be empty.");
        }
        return input.trim();
    }
}