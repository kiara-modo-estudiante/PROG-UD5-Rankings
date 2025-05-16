package com.ripadbisor.views.components;

import javax.swing.*;
import java.awt.*;
import com.ripadbisor.models.DiveSpot;

public class DiveSpotPanel extends JPanel {
    public DiveSpotPanel(DiveSpot diveSpot, JButton button) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel
        setBackground(new Color(245, 245, 245)); // Light gray background
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 150)); // Ensure consistent height

        // Left panel for name, location, depth, and marine life
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(245, 245, 245));

        // Name
        JLabel nameLabel = new JLabel(diveSpot.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font for the name
        nameLabel.setForeground(new Color(50, 50, 50)); // Dark gray text
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(nameLabel);

        // Location
        JLabel locationLabel = new JLabel("📍 " + diveSpot.getLocation());
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        locationLabel.setForeground(new Color(100, 100, 100)); // Medium gray text
        locationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(locationLabel);

        // Add breathing space
        leftPanel.add(Box.createVerticalStrut(10));

        // Depth
        JLabel depthLabel = new JLabel("Depth: " + diveSpot.getMaxDepth() + " meters");
        depthLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        depthLabel.setForeground(new Color(80, 80, 80)); // Slightly darker gray
        depthLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(depthLabel);

        // Recommended season
        JLabel seasonLabel = new JLabel("Season: " + diveSpot.getRecommendedSeason());
        seasonLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        seasonLabel.setForeground(new Color(80, 80, 80));
        seasonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(seasonLabel);

        // Marine life
        String marineLifeText = diveSpot.isHasMarineLife() ? "Marine Life: Yes 🐬" : "Marine Life: No 🚤";
        JLabel marineLifeLabel = new JLabel(marineLifeText);
        marineLifeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        marineLifeLabel.setForeground(new Color(80, 80, 80));
        marineLifeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(marineLifeLabel);

        add(leftPanel, BorderLayout.WEST);

        // Right panel for rating and delete button
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(245, 245, 245));
        rightPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Rating
        JLabel ratingLabel = new JLabel("Rating: ");
        ratingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ratingLabel.setForeground(new Color(50, 50, 50));
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(ratingLabel);

        // Stars for rating
        JPanel starsPanel = new JPanel();
        starsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));
        starsPanel.setBackground(new Color(245, 245, 245));
        for (int i = 0; i < diveSpot.getRating(); i++) {
            JLabel starLabel = new JLabel("⭐");
            starLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            starsPanel.add(starLabel);
        }
        rightPanel.add(starsPanel);

        // Add breathing space
        rightPanel.add(Box.createVerticalStrut(10));

        // Button
        if (button != null) {
            button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            button.setBackground(new Color(255, 102, 102)); // Light red background
            button.setForeground(Color.WHITE); // White text
            button.setFocusPainted(false); // Remove focus border
            button.setFont(new Font("Arial", Font.BOLD, 22)); // Bold font for the button
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            rightPanel.add(button);
        }

        add(rightPanel, BorderLayout.EAST);

        // Add rounded corners and shadow effect
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1), // Light gray border
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Padding inside the border
    }
}