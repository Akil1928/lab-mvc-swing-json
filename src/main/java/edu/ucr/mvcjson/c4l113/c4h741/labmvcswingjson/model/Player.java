package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model;

/**
 * Represents a sports player with name, sport, position and shirt number.
 * Uses standard JavaBean style so Jackson can serialize/deserialize it.
 */
public class Player {

    private String name;
    private Sport sport;
    private String position;
    private int shirtNumber;

    /** No-arg constructor required by Jackson. */
    public Player() {}

    /**
     * Creates a fully initialized Player.
     *
     * @param name        the player's full name (non-empty)
     * @param sport       the sport the player practices
     * @param position    the player's field position
     * @param shirtNumber the player's shirt number (> 0)
     */
    public Player(String name, Sport sport, String position, int shirtNumber) {
        this.name = name;
        this.sport = sport;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

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

    // ── Setters (required by Jackson) ────────────────────────────────────────

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
