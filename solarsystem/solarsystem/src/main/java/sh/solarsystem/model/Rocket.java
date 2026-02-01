package sh.solarsystem.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * A rocket that the player can move around the solar system.
 * Handles movement, drawing, and collision boundaries.
 */
public class Rocket {

    private double x, y;
    private double velocityX = 0, velocityY = 0;
    private final double width = 10, height = 10;

    /**
     * Creates the rocket at a given start position.
     *
     * @param startX X position to begin at
     * @param startY Y position to begin at
     */
    public Rocket(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void setVelocityX(double vx) {
        this.velocityX = vx;
    }

    public void setVelocityY(double vy) {
        this.velocityY = vy;
    }

    /**
     * Moves the rocket based on its velocity.
     */
    public void update() {
        x += velocityX;
        y += velocityY;
    }

    /**
     * Draws the rocket on screen using the provided context.
     *
     * @param gc the graphics context used for rendering
     */
    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, width, height);
    }

    /**
     * Gets the rocket's position and size for hit detection.
     *
     * @return A rectangle representing the rocket's area
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
