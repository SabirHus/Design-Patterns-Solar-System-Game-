package sh.solarsystem.command;

import sh.solarsystem.controller.SolarSystemController;

/**
 * Command to pause the solar system simulation.
 * Follows the Command design pattern.
 */
public class PauseCommand implements Command {

    private final SolarSystemController controller;

    /**
     * Creates a new pause command.
     *
     * @param controller The controller managing the simulation state.
     */
    public PauseCommand(SolarSystemController controller) {
        this.controller = controller;
    }

    /**
     * Executes the pause action.
     */
    @Override
    public void execute() {
        controller.pause();
    }
}
