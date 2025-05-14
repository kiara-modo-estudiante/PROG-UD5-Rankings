package com.ripadbisor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private MainFrame mainFrame;

    public MainMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new GridLayout(5, 1, 10, 10)); // 5 botones con espacio entre ellos

        // Botón para añadir un elemento
        JButton addButton = new JButton("Añadir Divespot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddDivespotForm();
            }
        });
        add(addButton);

        // Botón para editar un elemento
        JButton editButton = new JButton("Editar Divespot");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showEditDivespotForm();
            }
        });
        add(editButton);

        // Botón para mostrar todos los elementos
        JButton showButton = new JButton("Mostrar Divespots");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAllDivespots();
            }
        });
        add(showButton);

        // Botón para eliminar un elemento
        JButton deleteButton = new JButton("Eliminar Divespot");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showDeleteDivespotForm();
            }
        });
        add(deleteButton);

        // Botón para salir del programa
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Termina la ejecución del programa
            }
        });
        add(exitButton);
    }
}