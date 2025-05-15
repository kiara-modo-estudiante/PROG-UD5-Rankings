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
    {
        divespots = new ArrayList<>();
        divespots.add(new Divespot("Blue Hole", "Belize", 124, "Winter", true, 5));
        divespots.add(new Divespot("Great Barrier Reef", "Australia", 40, "Spring", true, 5));
        divespots.add(new Divespot("Silfra Fissure", "Iceland", 18, "Summer", false, 4));
        divespots.add(new Divespot("Richelieu Rock", "Thailand", 35, "Autumn", true, 5));
        divespots.add(new Divespot("USS Liberty", "Bali", 30, "Winter", true, 4));
    }

    public DivespotList() {
        // divespots = new ArrayList<>();
    }

    // Add a getter for the list of divespots
    public List<Divespot> getDivespots() {
        return divespots;
    }

    // Add a new Divespot to the list
    public void addDivespot(Divespot divespot) {
        divespots.add(divespot);
    }

    // Delete a Divespot from the list by name
    public boolean removeDivespot(String name) {
        for (Divespot divespot : divespots) {
            if (divespot.getName().equals(name)) {
                divespots.remove(divespot);
                return true;
            }
        }
        return false;
    }

    // Show all divespots in the list
    public void showAllDivespots() {
        if (divespots.isEmpty()) {
            System.out.println("No divespots registered.");
        } else {
            for (Divespot divespot : divespots) {
                System.out.println(divespot.toString());
                System.out.println("------------------------------------------");
            }
        }
    }

    // Find divespot by name
    public Divespot findDivespotByName(String name) {
        for (Divespot divespot : divespots) {
            if (divespot.getName().equals(name)) {
                return divespot;
            }
        }
        return null;
    }

}
