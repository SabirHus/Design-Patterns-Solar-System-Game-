package sh.solarsystem.view;

import javafx.scene.control.Label;

/**
 * Displays how many planets have been visited so far.
 * Used as part of the game's HUD.
 */
public class ScoreLabel extends Label {

    private int visitedCount = 0;

    /**
     * Creates a score label with initial count set to 0.
     */
    public ScoreLabel() {
        super("Visited: 0");
        setLayoutX(10);
        setLayoutY(70);
        setStyle("-fx-text-fill: white;");
    }

    /**
     * Updates the label to show how many planets have been visited.
     *
     * @param count Number of planets visited
     */
    public void updateVisited(int count) {
        this.visitedCount = count;
        setText("Visited: " + visitedCount);
    }
}
