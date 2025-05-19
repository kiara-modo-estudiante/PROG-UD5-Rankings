/**
 * Utility class providing methods for creating and managing UI components.
 * 
 * This class contains helper methods to simplify the creation of 
 * user interface elements, such as scrollable panels with predefined 
 * layouts and styles.
 */
package com.ripadbisor.utils;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.BorderFactory;

public class UIUtils {
    /**
     * Creates a scrollable panel with a vertical box layout.
     *
     * @param panel The JPanel to be made scrollable.
     * @return A JScrollPane containing the provided JPanel.
     */
    public static JScrollPane createScrollablePanel(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return scrollPane;
    }

    /**
     * Creates a JLabel with the specified text and color.
     *
     * @param text  The text to be displayed on the label.
     * @param color The color of the label's text.
     * @return A JLabel with the specified text and color.
     */
    public static JLabel createMessageLabel(Color color) {
        JLabel label = new JLabel("");
        label.setForeground(color);
        return label;
    }
}