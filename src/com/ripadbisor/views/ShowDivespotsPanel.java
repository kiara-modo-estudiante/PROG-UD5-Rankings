/**
 * The ShowDiveSpotsPanel class is a custom JPanel that displays a list of diveSpots
 * in a scrollable panel, sorted by their rating in descending order. It includes a 
 * back button to navigate back to the main menu.
 *
 * Purpose:
 * - Provides a user interface for viewing diveSpots in a structured and organized manner.
 * - Displays diveSpots using individual DiveSpotPanel components.
 * - Allows navigation back to the main menu via a back button.
 *
 * Components:
 * - A top panel containing a back button for navigation.
 * - A center panel with a scrollable list of diveSpots, sorted by rating.
 */
package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import com.ripadbisor.models.DiveSpot;
import com.ripadbisor.models.DiveSpotList;
import com.ripadbisor.views.components.BackButtonPanel;
import com.ripadbisor.views.components.DiveSpotPanel;

public class ShowDiveSpotsPanel extends JPanel {
    public ShowDiveSpotsPanel(MainFrame mainFrame, DiveSpotList diveSpotList) {
        setLayout(new BorderLayout());

        // Top panel with back button
        add(new BackButtonPanel(e -> mainFrame.showMainMenu()), BorderLayout.NORTH);

        // Center panel to display the list of diveSpots
        JPanel diveSpotListPanel = new JPanel();
        diveSpotListPanel.setLayout(new BoxLayout(diveSpotListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(diveSpotListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Sort diveSpots by rating (descending order)
        List<DiveSpot> sortedDiveSpots = diveSpotList.getDiveSpots().stream()
                .sorted((d1, d2) -> Integer.compare(d2.getRating(), d1.getRating()))
                .collect(Collectors.toList());

        // Populate the panel with sorted diveSpots
        for (DiveSpot diveSpot : sortedDiveSpots) {
            // Use DiveSpotPanel to display each diveSpot
            DiveSpotPanel diveSpotPanel = new DiveSpotPanel(diveSpot, null); // No button needed
            diveSpotListPanel.add(diveSpotPanel);
        }

        diveSpotListPanel.revalidate();
        diveSpotListPanel.repaint();
    }
}