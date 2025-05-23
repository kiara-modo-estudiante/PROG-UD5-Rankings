/**
* The DiveSpot class represents a diving spot with various attributes
* such as its name, location, maximum depth, recommended diving season,
* whether it has marine life, and its rating.
*
* Purpose:
* This class is designed to encapsulate the details of a diving spot,
* providing getter and setter methods to access and modify its properties.
*/
package com.ripadbisor.models;

public class DiveSpot {

    private String name;
    private String location;
    private int maxDepth;
    private String recommendedSeason;
    private boolean hasMarineLife;
    private int rating;

    public DiveSpot(String name, String location, int maxDepth, String recommendedSeason, boolean hasMarineLife,
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

    @Override
    public String toString() {
        return String.format(
                "Name: %s\nLocation: %s\nMax. depth: %d meters\nRecommended season: %s\nMarine life: %s\nRating: %d stars\n",
                name, location, maxDepth, recommendedSeason, hasMarineLife ? "Yes" : "No", rating);
    }
}
