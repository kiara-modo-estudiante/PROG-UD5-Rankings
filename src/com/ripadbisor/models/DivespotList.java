/**
 * La clase DivespotList representa una lista de lugares de buceo (Divespots).
 * Su objetivo principal es proporcionar una estructura para gestionar una colección
 * de objetos Divespot, permitiendo agregar, eliminar, buscar y mostrar información
 * sobre los lugares de buceo registrados.
 * 
 * Objetivos:
 * - Facilitar la gestión de una lista de lugares de buceo.
 * - Proveer métodos para agregar y eliminar lugares de buceo.
 * - Permitir la búsqueda de un lugar de buceo por su nombre.
 * - Mostrar información detallada de todos los lugares de buceo registrados.
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
