package sh.solarsystem.view;

import javafx.scene.control.Label;

/**
 * Displays the current speed multiplier for orbit movement.
 * Part of the game's HUD.
 */
public class SpeedLabel extends Label {

    private double currentMultiplier = 1.0;

    /**
     * Constructs the label with default speed value x1.0.
     */
    public SpeedLabel() {
        super("Speed: x1.0");
        setLayoutX(10);
        setLayoutY(50);
        setStyle("-fx-text-fill: white;");
    }

    /**
     * Updates the speed text shown on the label.
     *
     * @param newSpeed Updated multiplier (e.g., 1.5x)
     */
    public void updateSpeed(double newSpeed) {
        this.currentMultiplier = newSpeed;
        setText(String.format("Speed: x%.1f", currentMultiplier));
    }

    /**
     * Gets the current multiplier value.
     *
     * @return current simulation speed
     */
    public double getCurrentMultiplier() {
        return currentMultiplier;
    }
}
