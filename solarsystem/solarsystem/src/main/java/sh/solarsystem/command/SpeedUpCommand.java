package sh.solarsystem.command;

import sh.solarsystem.controller.SolarSystemController;

/**
 * Command to increase the orbit speed of the planets.
 * Part of the Command design pattern.
 */
public class SpeedUpCommand implements Command {

    private final SolarSystemController controller;

    /**
     * Creates a command that increases the simulation speed.
     *
     * @param controller The controller that manages simulation updates.
     */
    public SpeedUpCommand(SolarSystemController controller) {
        this.controller = controller;
    }

    /**
     * Executes the speed-up action.
     */
    @Override
    public void execute() {
        controller.speedUp();
    }
}
