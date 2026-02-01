package sh.solarsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sh.solarsystem.controller.SolarSystemController;
import sh.solarsystem.model.Rocket;
import sh.solarsystem.view.SolarSystemView;
import sh.solarsystem.command.*;

/**
 * Main class for launching the Solar System Exploration game.
 * Sets up the start screen, game, and end screen.
 */
public class SolarSystemApp extends Application {

    private Stage mainWindow;

    @Override
    public void start(Stage stage) {
        this.mainWindow = stage;
        showStartScreen();
    }

    /**
     * Shows the start menu with game instructions and start button.
     */
    private void showStartScreen() {
        Pane layout = new Pane();

        Label title = new Label("Solar System Exploration");
        title.setLayoutX(280);
        title.setLayoutY(120);
        title.setStyle("-fx-font-size: 26px; -fx-text-fill: purple;");

        Label instructions = new Label("Use W/A/S/D to move. Visit all planets to discover facts.");
        instructions.setLayoutX(240);
        instructions.setLayoutY(180);
        instructions.setStyle("-fx-text-fill: purple;");

        Button startButton = new Button("Start Game");
        startButton.setLayoutX(350);
        startButton.setLayoutY(260);
        startButton.setOnAction(e -> launchGame());

        layout.getChildren().addAll(title, instructions, startButton);
        Scene scene = new Scene(layout, 800, 600, Color.BLACK);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     * Starts the game and sets up controller and view.
     */
    private void launchGame() {
        Rocket rocket = new Rocket(390, 290);
        SolarSystemView view = new SolarSystemView();
        SolarSystemController controller = new SolarSystemController(view, rocket, this::showEndScreen);

        view.getPauseButton().setOnAction(e -> new PauseCommand(controller).execute());
        view.getResumeButton().setOnAction(e -> new ResumeCommand(controller).execute());
        view.getFasterButton().setOnAction(e -> new SpeedUpCommand(controller).execute());
        view.getSlowerButton().setOnAction(e -> new SlowDownCommand(controller).execute());

        controller.start();
        mainWindow.setScene(view.getScene());
    }

    /**
     * Displays the end screen with completion time and restart option.
     */
    private void showEndScreen(long secondsElapsed) {
        Pane layout = new Pane();

        Label message = new Label("You visited all 8 planets.");
        message.setLayoutX(270);
        message.setLayoutY(180);
        message.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");

        Label timeLabel = new Label("Time taken: " + secondsElapsed + " seconds");
        timeLabel.setLayoutX(300);
        timeLabel.setLayoutY(230);
        timeLabel.setStyle("-fx-text-fill: red;");

        Button restartButton = new Button("Play Again");
        restartButton.setLayoutX(350);
        restartButton.setLayoutY(280);
        restartButton.setOnAction(e -> showStartScreen());

        layout.getChildren().addAll(message, timeLabel, restartButton);
        Scene scene = new Scene(layout, 800, 600, Color.BLACK);
        mainWindow.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
