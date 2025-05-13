/**
* La clase Divespot representa un lugar de buceo con varios atributos
* como su nombre, ubicación, profundidad máxima, temporada recomendada para bucear,
* si tiene vida marina y su calificación.
*
* Objetivo:
* Esta clase está diseñada para encapsular los detalles de un lugar de buceo,
* proporcionando métodos getter y setter para acceder y modificar sus propiedades.
*/
package com.ripadbisor.models;

public class Divespot {

    private String name;
    private String location;
    private int maxDepth;
    private String recommendedSeason;
    private boolean hasMarineLife;
    private int rating;

    public Divespot(String name, String location, int maxDepth, String recommendedSeason, boolean hasMarineLife,
            int rating) {
        this.name = name;
        this.location = location;
        this.maxDepth = maxDepth;
        this.recommendedSeason = recommendedSeason;
        this.hasMarineLife = hasMarineLife;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public String getRecommendedSeason() {
        return recommendedSeason;
    }

    public void setRecommendedSeason(String recommendedSeason) {
        this.recommendedSeason = recommendedSeason;
    }

    public boolean isHasMarineLife() {
        return hasMarineLife;
    }

    public void setHasMarineLife(boolean hasMarineLife) {
        this.hasMarineLife = hasMarineLife;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
