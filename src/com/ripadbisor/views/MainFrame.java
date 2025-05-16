/**
 * The MainFrame class represents the main window of the Divespot Manager application.
 * It serves as the primary user interface, allowing users to interact with the application
 * to manage and display information about divespots.
 *
 * This class extends JFrame and utilizes a BorderLayout to organize its components.
 * It includes a form for inputting divespot data, a display area for showing divespot
 * information, and integrates with the DivespotList model to manage the data.
 *
 * Key Components:
 * - DivespotForm: A form for user input, located at the top of the frame.
 * - JTextArea: A non-editable text area for displaying divespot information.
 * - DivespotList: A model that stores and manages the list of divespots.
 */
package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import com.ripadbisor.models.DivespotList;
import com.ripadbisor.views.forms.DeleteDivespotForm;
import com.ripadbisor.views.forms.AddDivespotForm;
import com.ripadbisor.views.forms.EditDivespotForm;

public class MainFrame extends JFrame {
    private JTextArea displayArea;
    private DivespotList divespotList;
    private JPanel currentPanel;

    public MainFrame() {
        // Initialize the DivespotList model
        setTitle("Divespot Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        divespotList = new DivespotList();

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

    public void showAddDivespotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new AddDivespotForm(this, divespotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showEditDivespotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new EditDivespotForm(this, divespotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showAllDivespots() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new ShowDivespotsPanel(this, divespotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showDeleteDivespotForm() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new DeleteDivespotForm(this, divespotList);
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Displays divespot information in the display area.
     *
     * @param info The information to display.
     */
    public void displayDivespotInfo(String info) {
        displayArea.append(info + "\n");
    }
}
