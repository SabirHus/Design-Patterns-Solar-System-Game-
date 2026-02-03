# Solar System Exploration

A JavaFX simulation game where you pilot a rocket through the solar system to discover planets and learn facts.

## Features
* **Real-time Orbit Simulation:** All 8 planets orbit the sun with unique speeds and distances.
* Interactive HUD:** On-screen buttons to control simulation speed and state (Pause/Resume/Speed Up/Slow Down).
* Fact Discovery:** Visit planets to trigger educational pop-ups.
* Score & Timer:** Tracks how many planets you have visited and your total time taken to complete the mission.

## Design Patterns Used
This project was developed as a demonstration of software engineering best practices:
* Model-View-Controller (MVC):** Separates core data (Model), the user interface (View), and the logic/input handling (Controller).
* Factory Pattern:** Used in `PlanetFactory` to instantiate different planet objects without repeating code.
* Command Pattern:** Encapsulates user actions (like Pause or Speed Up) into separate classes to improve modularity and scalability.

## How to Play
1. **Launch:** Run the `SolarSystemApp` class.
2. **Move:** Use **W/A/S/D** to navigate your rocket.
3. **Explore:** Fly into a planet's path to "visit" it and read a fact about it.
4. **Control:** Use the on-screen buttons to adjust the simulation speed.
5. **Win:** Visit all 8 planets to see your final completion time.

## Technical Requirements
* **Java:** JDK 11 or higher (Project configured for Java 11).
* **Dependencies:** OpenJFX (JavaFX) controls and graphics.
* **Build Tool:** Maven.

## Project Structure
* `sh.solarsystem.model`: Contains `Planet`, `Rocket`, and `SolarSystemModel`.
* `sh.solarsystem.view`: Contains `SolarSystemView`, `ScoreLabel`, and `SpeedLabel`.
* `sh.solarsystem.controller`: Handles simulation logic and collision detection.
* `sh.solarsystem.command`: Implements the Command pattern for UI buttons.
* `sh.solarsystem.factory`: Implements the Factory pattern for planet creation.
