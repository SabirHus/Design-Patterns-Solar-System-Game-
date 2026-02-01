package sh.solarsystem.view;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sh.solarsystem.model.Rocket;

import java.util.Random;

/**
 * Handles rendering and UI layout for the solar system view.
 * Displays canvas, HUD labels, controls, and handles rocket movement.
 */
public class SolarSystemView {

    private final Canvas canvas = new Canvas(800, 600);
    private final SpeedLabel speedLabel = new SpeedLabel();
    private final ScoreLabel scoreLabel = new ScoreLabel();
    private final Pane root = new Pane();
    private Rocket rocket;

    // Control buttons
    private final Button fasterButton = new Button("Faster");
    private final Button slowerButton = new Button("Slower");
    private final Button pauseButton = new Button("Pause");
    private final Button resumeButton = new Button("Resume");

    // Star field data
    private final int STAR_COUNT = 150;
    private final double[][] stars = new double[STAR_COUNT][2];

    /**
     * Constructs the view and sets up UI elements and star background.
     */
    public SolarSystemView() {
        root.getChildren().add(canvas);

        // Layout controls
        fasterButton.setLayoutX(10);
        slowerButton.setLayoutX(80);
        pauseButton.setLayoutX(150);
        resumeButton.setLayoutX(220);
        root.getChildren().addAll(fasterButton, slowerButton, pauseButton, resumeButton);

        // HUD labels
        speedLabel.setTextFill(Color.WHITE);
        scoreLabel.setTextFill(Color.WHITE);
        speedLabel.setLayoutX(10); speedLabel.setLayoutY(50);
        scoreLabel.setLayoutX(10); scoreLabel.setLayoutY(70);
        root.getChildren().addAll(speedLabel, scoreLabel);

        // Generate stars
        Random rand = new Random();
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i][0] = rand.nextDouble() * canvas.getWidth();
            stars[i][1] = rand.nextDouble() * canvas.getHeight();
        }
    }

    /**
     * Returns the main game scene with key handlers for rocket control.
     */
    public Scene getScene() {
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        scene.setOnKeyPressed(e -> {
            if (rocket == null) return;
            if (e.getCode() == KeyCode.W) rocket.setVelocityY(-2);
            if (e.getCode() == KeyCode.S) rocket.setVelocityY(2);
            if (e.getCode() == KeyCode.A) rocket.setVelocityX(-2);
            if (e.getCode() == KeyCode.D) rocket.setVelocityX(2);
        });
        scene.setOnKeyReleased(e -> {
            if (rocket == null) return;
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.S) rocket.setVelocityY(0);
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.D) rocket.setVelocityX(0);
        });
        return scene;
    }

    /**
     * Assigns the rocket instance to track for key controls.
     */
    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    public SpeedLabel getSpeedLabel() {
        return speedLabel;
    }

    public ScoreLabel getScoreLabel() {
        return scoreLabel;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Button getFasterButton() {
        return fasterButton;
    }

    public Button getSlowerButton() {
        return slowerButton;
    }

    public Button getPauseButton() {
        return pauseButton;
    }

    public Button getResumeButton() {
        return resumeButton;
    }

    /**
     * Renders a black background and star field.
     */
    public void renderBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.rgb(255, 255, 255, 0.25));
        for (double[] star : stars) {
            gc.fillOval(star[0], star[1], 1.5, 1.5);
        }
    }

    /**
     * Draws a soft glow around visited planets.
     */
    public void renderPlanetGlow(GraphicsContext gc, double x, double y, double radius) {
        gc.setFill(Color.rgb(255, 255, 0, 0.3)); // Yellow glow
        gc.fillOval(x - 4, y - 4, radius + 8, radius + 8);
    }
}
