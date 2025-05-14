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

public class MainFrame extends JFrame {
    private DivespotForm divespotForm;
    private JTextArea displayArea;
    private DivespotList divespotList;

    public MainFrame() {
        // Initialize the DivespotList model
        setTitle("Divespot Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        divespotList = new DivespotList();
        divespotForm = new DivespotForm(this, divespotList);
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Set up the display area with a border
        add(divespotForm, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setVisible(true);
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
