package sh.solarsystem.factory;

import javafx.scene.paint.Color;
import sh.solarsystem.model.Planet;

/**
 * Creates specific planet objects with pre-defined attributes.
 * Implements the PlanetFactoryIF interface.
 */
public class PlanetFactory implements PlanetFactoryIF {

    /**
     * Builds and returns a planet instance with the correct data and fun fact.
     *
     * @param name the name of the planet (e.g. "Earth", "Mars")
     * @return the configured Planet object, or null if the name is not recognised
     */
    @Override
    public Planet createPlanet(String name) {
        Planet planet = null;

        if (name.equalsIgnoreCase("Mercury")) {
            planet = new Planet("Mercury", 30, 0.015, Color.GREY, 6);
            planet.setFact("Mercury is the smallest planet in our solar system.");
        } else if (name.equalsIgnoreCase("Venus")) {
            planet = new Planet("Venus", 45, 0.012, Color.BEIGE, 10);
            planet.setFact("Venus has a very thick and toxic atmosphere.");
        } else if (name.equalsIgnoreCase("Earth")) {
            planet = new Planet("Earth", 60, 0.010, Color.AQUA, 12);
            planet.setFact("Earth is the only planet known to support life.");
        } else if (name.equalsIgnoreCase("Mars")) {
            planet = new Planet("Mars", 75, 0.008, Color.RED, 9);
            planet.setFact("Mars is known as the Red Planet.");
        } else if (name.equalsIgnoreCase("Jupiter")) {
            planet = new Planet("Jupiter", 100, 0.006, Color.ORANGE, 20);
            planet.setFact("Jupiter is the largest planet in the solar system.");
        } else if (name.equalsIgnoreCase("Saturn")) {
            planet = new Planet("Saturn", 125, 0.005, Color.KHAKI, 18);
            planet.setFact("Saturn is famous for its large and visible rings.");
        } else if (name.equalsIgnoreCase("Uranus")) {
            planet = new Planet("Uranus", 150, 0.004, Color.WHITE, 16);
            planet.setFact("Uranus rotates on its side!");
        } else if (name.equalsIgnoreCase("Neptune")) {
            planet = new Planet("Neptune", 175, 0.003, Color.LIGHTBLUE, 16);
            planet.setFact("Neptune has the strongest winds in the solar system.");
        }

        return planet;
    }
}
