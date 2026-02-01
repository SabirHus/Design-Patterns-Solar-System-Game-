package sh.solarsystem.command;

import sh.solarsystem.controller.SolarSystemController;

/**
 * Command to slow down the orbit speed of the planets.
 * Follows the Command design pattern.
 */
public class SlowDownCommand implements Command {

    private final SolarSystemController controller;

    /**
     * Creates a command that slows down the simulation.
     *
     * @param controller The controller managing the simulation speed.
     */
    public SlowDownCommand(SolarSystemController controller) {
        this.controller = controller;
    }

    /**
     * Executes the slow down action.
     */
    @Override
    public void execute() {
        controller.slowDown();
    }
}
