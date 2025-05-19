/**
 * The DiveSpotList class represents a list of diving spots (DiveSpots).
 * Its main purpose is to provide a structure to manage a collection
 * of DiveSpot objects, allowing adding, removing, searching, and displaying
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

public class DiveSpotList {
    private List<DiveSpot> diveSpots;
    {
        diveSpots = new ArrayList<>();
        diveSpots.add(new DiveSpot("Blue Hole", "Belize", 124, "Winter", true, 5));
        diveSpots.add(new DiveSpot("Great Barrier Reef", "Australia", 40, "Spring", true, 5));
        diveSpots.add(new DiveSpot("Silfra Fissure", "Iceland", 18, "Summer", false, 4));
        diveSpots.add(new DiveSpot("Richelieu Rock", "Thailand", 35, "Autumn", true, 5));
        diveSpots.add(new DiveSpot("USS Liberty", "Bali", 30, "Winter", true, 4));
    }

    public DiveSpotList() {
        // diveSpots = new ArrayList<>();
    }

    // Add a getter for the list of diveSpots
    public List<DiveSpot> getDiveSpots() {
        return diveSpots;
    }

    // Add a new DiveSpot to the list
    public void addDiveSpot(DiveSpot diveSpot) {
        diveSpots.add(diveSpot);
    }

    // Delete a DiveSpot from the list by name
    public boolean removeDiveSpot(String name) {
        for (DiveSpot diveSpot : diveSpots) {
            if (diveSpot.getName().equals(name)) {
                diveSpots.remove(diveSpot);
                return true;
            }
        }
        return false;
    }

    // Show all diveSpots in the list
    public void showAllDiveSpots() {
        if (diveSpots.isEmpty()) {
            System.out.println("No diveSpots registered.");
        } else {
            for (DiveSpot diveSpot : diveSpots) {
                System.out.println(diveSpot.toString());
                System.out.println("------------------------------------------");
            }
        }
    }

    // Find diveSpot by name
    public DiveSpot findDiveSpotByName(String name) {
        for (DiveSpot diveSpot : diveSpots) {
            if (diveSpot.getName().equals(name)) {
                return diveSpot;
            }
        }
        return null;
    }

}
