/**
 * The MainFrame class represents the main window of the DiveSpot Manager application.
 * It serves as the primary user interface, allowing users to interact with the application
 * to manage and display information about diveSpots.
 *
 * This class extends JFrame and utilizes a BorderLayout to organize its components.
 * It includes a form for inputting diveSpot data, a display area for showing diveSpot
 * information, and integrates with the DiveSpotList model to manage the data.
 *
 * Key Components:
 * - DiveSpotForm: A form for user input, located at the top of the frame.
 * - JTextArea: A non-editable text area for displaying diveSpot information.
 * - DiveSpotList: A model that stores and manages the list of diveSpots.
 */
package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import com.ripadbisor.models.DiveSpotList;
import com.ripadbisor.views.forms.DeleteDiveSpotForm;
import com.ripadbisor.views.forms.AddDiveSpotForm;
import com.ripadbisor.views.forms.EditDiveSpotForm;
import com.ripadbisor.views.panels.MainMenu;
import com.ripadbisor.views.panels.ShowDiveSpotsPanel;

public class MainFrame extends JFrame {
    private JTextArea displayArea;
    private DiveSpotList diveSpotList;
    private JPanel currentPanel;

    public MainFrame() {
        // Initialize the DiveSpotList model
        setTitle("DiveSpot Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        diveSpotList = new DiveSpotList();

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        showMainMenu();
    }

    public void showMainMenu() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new MainMenu(this);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showAddDiveSpotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new AddDiveSpotForm(this, diveSpotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showEditDiveSpotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new EditDiveSpotForm(this, diveSpotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showAllDiveSpots() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new ShowDiveSpotsPanel(this, diveSpotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showDeleteDiveSpotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new DeleteDiveSpotForm(this, diveSpotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Displays diveSpot information in the display area.
     *
     * @param info The information to display.
     */
    public void displayDiveSpotInfo(String info) {
        displayArea.append(info + "\n");
    }
}
