/**
 * The DivespotList class represents a list of diving spots (Divespots).
 * Its main purpose is to provide a structure to manage a collection
 * of Divespot objects, allowing adding, removing, searching, and displaying
 * information about the registered diving spots.
 * 
 * Purpose:
 * - Facilitate the management of a list of diving spots.
 * - Provide methods to add and remove diving spots.
 * - Allow searching for a diving spot by its name.
 * - Display detailed information about all registered diving spots.
 */
package com.ripadbisor.models;

import java.util.ArrayList;
import java.util.List;

public class DivespotList {
    private List<Divespot> divespots;

    public DivespotList() {
        divespots = new ArrayList<>();
    }

    // Agregar un Divespot a la lista
    public void addDivespot(Divespot divespot) {
        divespots.add(divespot);
    }

    // Eliminar un Divespot de la lista por nombre
    public boolean removeDivespot(String name) {
        for (Divespot divespot : divespots) {
            if (divespot.getName().equals(name)) {
                divespots.remove(divespot);
                return true;
            }
        }
        return false;
    }

    // Mostrar todos los Divespots en la lista
    public void showAllDivespots() {
        if (divespots.isEmpty()) {
            System.out.println("No hay lugares de buceo registrados.");
        } else {
            for (Divespot divespot : divespots) {
                System.out.println("Nombre: " + divespot.getName());
                System.out.println("Ubicación: " + divespot.getLocation());
                System.out.println("Profundidad máxima: " + divespot.getMaxDepth() + " metros");
                System.out.println("Temporada recomendada: " + divespot.getRecommendedSeason());
                System.out.println("¿Tiene vida marina? " + (divespot.isHasMarineLife() ? "Sí" : "No"));
                System.out.println("Calificación: " + divespot.getRating() + " estrellas");
                System.out.println("------------------------------------------");
            }
        }
    }

    // Buscar un Divespot por nombre
    public Divespot findDivespotByName(String name) {
        for (Divespot divespot : divespots) {
            if (divespot.getName().equals(name)) {
                return divespot;
            }
        }
        return null;
    }

}
