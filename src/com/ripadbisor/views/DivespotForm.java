package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ripadbisor.models.Divespot;
import com.ripadbisor.models.DivespotList;

public class DivespotForm extends JPanel {
    private JTextField nameField;
    private JTextField locationField;
    private JTextField maxDepthField;
    private JTextField seasonField;
    private JCheckBox marineLifeCheckBox;
    private JTextField ratingField;
    private JButton submitButton;

    private MainFrame mainFrame;
    private DivespotList divespotList;

    public DivespotForm(MainFrame mainFrame, DivespotList divespotList) {
        this.mainFrame = mainFrame;
        this.divespotList = divespotList;

        setLayout(new GridLayout(7, 2));

        add(new JLabel("Nombre:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Ubicación:"));
        locationField = new JTextField();
        add(locationField);

        add(new JLabel("Profundidad máxima:"));
        maxDepthField = new JTextField();
        add(maxDepthField);

        add(new JLabel("Temporada recomendada:"));
        seasonField = new JTextField();
        add(seasonField);

        add(new JLabel("¿Tiene vida marina?"));
        marineLifeCheckBox = new JCheckBox();
        add(marineLifeCheckBox);

        add(new JLabel("Calificación:"));
        ratingField = new JTextField();
        add(ratingField);

        submitButton = new JButton("Agregar Divespot");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String location = locationField.getText();
                    int maxDepth = Integer.parseInt(maxDepthField.getText());
                    String season = seasonField.getText();
                    boolean hasMarineLife = marineLifeCheckBox.isSelected();
                    int rating = Integer.parseInt(ratingField.getText());

                    Divespot divespot = new Divespot(name, location, maxDepth, season, hasMarineLife, rating);
                    divespotList.addDivespot(divespot);

                    String info = String.format(
                            "Nombre: %s\nUbicación: %s\nProfundidad máxima: %d\nTemporada recomendada: %s\n¿Tiene vida marina?: %s\nCalificación: %d\n",
                            name, location, maxDepth, season, hasMarineLife ? "Sí" : "No", rating);
                    mainFrame.displayDivespotInfo(info);

                    nameField.setText("");
                    locationField.setText("");
                    maxDepthField.setText("");
                    seasonField.setText("");
                    marineLifeCheckBox.setSelected(false);
                    ratingField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Por favor, ingresa datos válidos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}