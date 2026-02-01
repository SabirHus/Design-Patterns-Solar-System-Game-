package sh.solarsystem.command;

import sh.solarsystem.controller.SolarSystemController;

/**
 * Command to resume the solar system simulation.
 * Part of the Command design pattern.
 */
public class ResumeCommand implements Command {

    private final SolarSystemController controller;

    /**
     * Creates a new resume command.
     *
     * @param controller The controller managing the simulation state.
     */
    public ResumeCommand(SolarSystemController controller) {
        this.controller = controller;
    }

    /**
     * Executes the resume action.
     */
    @Override
    public void execute() {
        controller.resume();
    }
}
