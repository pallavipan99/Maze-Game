# Maze Game

A fun **Maze Game** where the player controls an explorer to navigate mazes, collect gold, avoid monsters, and reach the finish. Built with Java, Swing, and image-based graphics for a visual, interactive experience.

---

## **Key Features**

- **Explorer Movement:** Use arrow keys to move the explorer through the maze in four directions.
- **Gold Collection:** Collect gold objects for points.
- **Monster Encounters:** Avoid monsters while navigating the maze.
- **Multiple Mazes:** Supports different maze layouts loaded from text files (`maze0.txt`, `maze1.txt`, etc.).
- **Graphical Display:** Visual feedback using images for explorer, gold, monsters, and other maze elements.
- **Scoring System:** Tracks collected points and displays a winning/losing message at the end.

---

## **Tech Stack**

| Layer      | Technology                                  |
| ---------- | ------------------------------------------- |
| Platform   | Java SE                                     |
| Language   | Java                                        |
| UI         | Swing (JFrame, JPanel, BufferedImage)      |
| Graphics   | PNG images for characters and objects      |
| File I/O   | Maze layout from `.txt` files              |

---

## **Project Structure**

| File               | Description                                                |
| -----------------  | ---------------------------------------------------------- |
| `Explorer.java`    | Handles player movement, direction, and steps taken.      |
| `Gold.java`        | Represents gold objects with points and visibility state. |
| `Monster.java`     | Represents monsters in the maze.                           |
| `Location.java`    | Stores row/column position of elements in the maze.       |
| `MazeElement.java` | Base class for all maze elements (Explorer, Gold, Monster).|
| `MazeProject.java` | Main class: initializes maze, runs game loop, renders UI.  |
| `maze0.txt`        | Maze layout file (text-based representation).             |
| `maze1.txt`        | Additional maze layout.                                   |
| `maze2.txt`        | Additional maze layout.                                   |
| `*.png`            | Images for explorer, gold, monsters, and other graphics.  |

---

## **Quick Start**

1. Clone the project to your local machine.
2. Open the project in an IDE like **IntelliJ IDEA** or **Eclipse**.
3. Make sure all `.png` image files are in the project directory.
4. Compile and run `MazeProject.java`.
5. Use **arrow keys** to move the explorer.
6. Collect gold, avoid monsters, and reach the finish to win.

---

## **Usage Notes**

- **Explorer Directions:** North, East, South, West are represented visually with images.
- **Gold Collection:** Only visible gold contributes to the score.
- **Monster Interaction:** Avoid moving into the monster’s location.
- **Maze Layout:** Change the `.txt` files to create custom mazes.
- **Game End:** Displays a message based on points collected.

---

## **Future Improvements**

- Add levels with increasing difficulty.
- Implement timer or countdown challenges.
- Add sound effects for movements, gold collection, and monster encounters.
- Introduce multiple explorers or multiplayer mode.
- Store high scores locally or online.
- Implement animations for smoother movement.

---

## **Acknowledgements**

This project demonstrates Java development skills including:

- Object-oriented programming with multiple classes.
- Event-driven programming using key listeners.
- Graphics rendering with Swing and BufferedImage.
- File I/O for loading maze layouts.
- Designing interactive games with scoring and win/loss conditions.

