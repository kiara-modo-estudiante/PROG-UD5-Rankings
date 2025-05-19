/**
 * A custom JPanel component that contains a back button for navigation.
 * The button is labeled "← Menu" and triggers a specified action when clicked.
 * 
 * Purpose:
 * This panel is designed to provide a consistent back navigation button
 * for use in various views of the application.
 * 
 * @param backAction The ActionListener to be executed when the back button is clicked.
 */

package com.ripadbisor.views.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BackButtonPanel extends JPanel {
    public BackButtonPanel(ActionListener backAction) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("← Menu");
        backButton.addActionListener(backAction);
        add(backButton);
    }
}