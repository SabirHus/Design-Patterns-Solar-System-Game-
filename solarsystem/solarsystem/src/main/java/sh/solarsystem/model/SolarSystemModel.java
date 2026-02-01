package sh.solarsystem.model;

import sh.solarsystem.factory.PlanetFactory;
import sh.solarsystem.factory.PlanetFactoryIF;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds all the planet data used in the simulation.
 * Created using a factory pattern for flexibility.
 * Part of the MVC: this is the Model.
 */
public class SolarSystemModel {

    private final List<Planet> planetList;           // All planet instances in the system
    private final PlanetFactoryIF planetFactory;     // Factory to generate planets

    /**
     * Constructs and loads all 8 planets into the solar system.
     */
    public SolarSystemModel() {
        this.planetFactory = new PlanetFactory();
        this.planetList = new ArrayList<>();

        String[] planetNames = {
            "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        for (String name : planetNames) {
            planetList.add(planetFactory.createPlanet(name));
        }
    }

    /**
     * Gets the list of all planets.
     *
     * @return List of Planet objects
     */
    public List<Planet> getPlanets() {
        return planetList;
    }
}
