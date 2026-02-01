package sh.solarsystem.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import sh.solarsystem.factory.PlanetFactory;
import sh.solarsystem.factory.PlanetFactoryIF;
import sh.solarsystem.model.Planet;
import sh.solarsystem.model.Rocket;
import sh.solarsystem.view.SolarSystemView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Controls the simulation logic of the solar system game.
 * Handles animation updates, interactions, and view refresh.
 */
public class SolarSystemController {

    private final SolarSystemView view;
    private final Rocket rocket;
    private final List<Planet> planets = new ArrayList<>();
    private final Consumer<Long> onComplete;

    private double speed = 1.0;
    private boolean paused = false;
    private int planetsVisited = 0;
    private long startTime;

    /**
     * Initialises the controller with the view, rocket, and end screen callback.
     *
     * @param view       the visual interface
     * @param rocket     the rocket object
     * @param onComplete callback triggered after all planets are visited
     */
    public SolarSystemController(SolarSystemView view, Rocket rocket, Consumer<Long> onComplete) {
        this.view = view;
        this.rocket = rocket;
        this.onComplete = onComplete;
    }

    /**
     * Starts the simulation and planet orbit animation.
     */
    public void start() {
        startTime = System.currentTimeMillis();
        view.setRocket(rocket);
        view.getSpeedLabel().updateSpeed(1.0);

        PlanetFactoryIF factory = new PlanetFactory();
        String[] planetNames = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
        for (String name : planetNames) {
            planets.add(factory.createPlanet(name));
        }

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                GraphicsContext gc = view.getGraphicsContext();

                view.renderBackground(gc);           // Draw stars
                drawSun(gc, 400, 300);               // Draw sun after background

                double centreX = 400;
                double centreY = 300;

                for (Planet planet : planets) {
                    if (!paused) planet.advanceOrbit(speed);

                    double x = planet.getX(centreX);
                    double y = planet.getY(centreY);

                    gc.setStroke(Color.DARKGREY);
                    gc.strokeOval(
                        centreX - planet.getDistanceFromSun(),
                        centreY - planet.getDistanceFromSun(),
                        planet.getDistanceFromSun() * 2,
                        planet.getDistanceFromSun() * 2
                    );

                    gc.setFill(planet.getColour());
                    gc.fillOval(x, y, planet.getRadius(), planet.getRadius());

                    gc.setFill(Color.WHITE);
                    gc.fillText(planet.getName(), x + planet.getRadius(), y + planet.getRadius() / 2);

                    if (planet.isVisited()) {
                        view.renderPlanetGlow(gc, x, y, planet.getRadius());
                    }

                    // Collision check: rocket touches unvisited planet
                    if (!planet.isVisited() && rocket.getBounds().intersects(x, y, planet.getRadius(), planet.getRadius())) {
                        planet.setVisited(true);
                        planetsVisited++;
                        view.getScoreLabel().updateVisited(planetsVisited);

                        paused = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Planet Discovered!");
                        alert.setHeaderText(planet.getName());
                        alert.setContentText(planet.getFact());
                        alert.setOnHidden(e -> paused = false);
                        alert.show();

                        // All planets visited - end game
                        if (planetsVisited == planets.size()) {
                            long elapsed = (System.currentTimeMillis() - startTime) / 1000;
                            stop();
                            onComplete.accept(elapsed);
                        }
                    }
                }

                rocket.update();
                rocket.render(gc);
            }
        }.start();
    }

    /**
     * Draws the sun at the centre with a soft glow.
     */
    private void drawSun(GraphicsContext gc, double centreX, double centreY) {
        gc.setFill(Color.rgb(255, 255, 0, 0.15));
        gc.fillOval(centreX - 25, centreY - 25, 50, 50);

        gc.setFill(Color.YELLOW);
        gc.fillOval(centreX - 15, centreY - 15, 30, 30);
    }

    /** Increases orbit speed. */
    public void speedUp() {
        speed += 0.5;
        view.getSpeedLabel().updateSpeed(speed);
    }

    /** Decreases orbit speed. */
    public void slowDown() {
        speed = Math.max(0.1, speed - 0.5);
        view.getSpeedLabel().updateSpeed(speed);
    }

    /** Pauses planet movement. */
    public void pause() {
        paused = true;
    }

    /** Resumes planet movement. */
    public void resume() {
        paused = false;
    }
}
