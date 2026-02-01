package sh.solarsystem.model;

import javafx.scene.paint.Color;

/**
 * A planet that orbits the sun in the simulation.
 * Stores orbit, position, appearance, and a fact about the planet.
 */
public class Planet {

    private final String name;
    private final int distanceFromSun;
    private final double orbitSpeed;
    private final Color colour;
    private final int radius;
    private double angle;
    private boolean visited = false;
    private String fact;

    /**
     * Sets up a planet with its key characteristics.
     *
     * @param name            planet name (e.g. Earth)
     * @param distanceFromSun how far from the centre (sun)
     * @param orbitSpeed      how quickly it moves
     * @param colour          its display colour
     * @param radius          how big it looks
     */
    public Planet(String name, int distanceFromSun, double orbitSpeed, Color colour, int radius) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.orbitSpeed = orbitSpeed;
        this.colour = colour;
        this.radius = radius;
        this.angle = 0;
    }

    /**
     * Rotates the planet by increasing its orbit angle.
     *
     * @param speedFactor speed multiplier applied to orbit
     */
    public void advanceOrbit(double speedFactor) {
        this.angle += orbitSpeed * speedFactor;
    }

    public double getX(double centreX) {
        return centreX + distanceFromSun * Math.cos(angle) - radius / 2.0;
    }

    public double getY(double centreY) {
        return centreY + distanceFromSun * Math.sin(angle) - radius / 2.0;
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public Color getColour() {
        return colour;
    }

    public int getRadius() {
        return radius;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
