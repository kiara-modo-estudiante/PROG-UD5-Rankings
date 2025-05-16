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