package sh.solarsystem.factory;

import sh.solarsystem.model.Planet;

/**
 * Factory interface for creating planet objects.
 * Ensures all factories follow a consistent contract.
 */
public interface PlanetFactoryIF {

    /**
     * Creates a planet instance based on the given type/name.
     *
     * @param type The name of the planet (e.g., "Earth", "Mars").
     * @return A Planet object configured with the appropriate properties.
     */
    Planet createPlanet(String type);
}
