/**
 * The ShowDivespotsPanel class is a custom JPanel that displays a list of divespots
 * in a scrollable panel, sorted by their rating in descending order. It includes a 
 * back button to navigate back to the main menu.
 *
 * Purpose:
 * - Provides a user interface for viewing divespots in a structured and organized manner.
 * - Displays divespots using individual DivespotPanel components.
 * - Allows navigation back to the main menu via a back button.
 *
 * Components:
 * - A top panel containing a back button for navigation.
 * - A center panel with a scrollable list of divespots, sorted by rating.
 */
package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.views.components.BackButtonPanel;
import com.ripadbisor.views.components.DivespotPanel;

public class ShowDivespotsPanel extends JPanel {
    public ShowDivespotsPanel(MainFrame mainFrame, DivespotList divespotList) {
        setLayout(new BorderLayout());

        // Top panel with back button
        add(new BackButtonPanel(e -> mainFrame.showMainMenu()), BorderLayout.NORTH);

        // Center panel to display the list of divespots
        JPanel divespotListPanel = new JPanel();
        divespotListPanel.setLayout(new BoxLayout(divespotListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(divespotListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Sort divespots by rating (descending order)
        List<Divespot> sortedDivespots = divespotList.getDivespots().stream()
                .sorted((d1, d2) -> Integer.compare(d2.getRating(), d1.getRating()))
                .collect(Collectors.toList());

        // Populate the panel with sorted divespots
        for (Divespot divespot : sortedDivespots) {
            // Use DivespotPanel to display each divespot
            DivespotPanel divespotPanel = new DivespotPanel(divespot, null); // No button needed
            divespotListPanel.add(divespotPanel);
        }

        divespotListPanel.revalidate();
        divespotListPanel.repaint();
    }
}