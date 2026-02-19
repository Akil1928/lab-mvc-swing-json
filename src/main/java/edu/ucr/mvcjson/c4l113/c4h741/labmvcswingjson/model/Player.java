package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model;

public class Player {

    private String name;
    private Sport sport;
    private String position;
    private int shirtNumber;

    public Player() {}

    public Player(String name, Sport sport, String position, int shirtNumber) {
        this.name = name;
        this.sport = sport;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }
    //getters

    public String getName() {
        return name;
    }

    public Sport getSport() {
        return sport;
    }

    public String getPosition() {
        return position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toString() {
        return "#" + shirtNumber + " " + name + " (" + sport + " - " + position + ")";
    }
}
