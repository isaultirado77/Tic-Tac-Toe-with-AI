# Tic-Tac-Toe with AI

## Project Description
**Tic-Tac-Toe with AI** is a Java project that implements the classic game of Tic-Tac-Toe for two players, with the option to play against an artificial intelligence (AI) that offers different difficulty levels: easy, medium, and hard. The most advanced level uses the **minimax** algorithm, ensuring optimal and challenging gameplay.
The game is designed as a command-line interface (CLI) and follows a modular structure organized into packages, which facilitates the separation of responsibilities between the board model, the players (both human and AI), and the game control logic. 

## Getting Started 

### Prerequisites

- Java Development Kit (JDK) installed on your machine. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html).

### Running the Application

1. Clone the repository or download the code files.
2. Navigate to the project directory.
3. Compile the Java code using the following command:
   ```sh
   javac Main.java
   ```
4. Run the application using the command:
   ```sh
   java Main
   ```
5. **Follow the On-Screen Prompts:**

## Example
```
Input command: > start hard user
Making move level "hard"
---------
|       |
| X     |
|       |
---------
Enter the coordinates: > 2 2
---------
|       |
| X O   |
|       |
---------
Making move level "hard"
---------
|   X   |
| X O   |
|       |
---------
Enter the coordinates: > 3 2
---------
|   X   |
| X O   |
|   O   |
---------
Making move level "hard"
---------
| X X   |
| X O   |
|   O   |
---------
Enter the coordinates: > 3 1
---------
| X X   |
| X O   |
| O O   |
---------
Making move level "hard"
---------
| X X X |
| X O   |
| O O   |
---------
X wins

Input command: > exit
```
### Project Structure

#### `io` Package

The `io` package handles data input and output in the command-line interface of the Tic-Tac-Toe game. It contains utilities for printing messages to the user and reading their input, keeping the presentation and data capture logic organized.

#### `model` Package

The `model` package forms the core of the Tic-Tac-Toe application, encapsulating all the logic necessary to represent and manage the game. This package is organized into two main subpackages: board and players, each with a specific focus for structuring the game model.

##### `board` Package
The `board` subpackage models the game board and its cells, including:

- **`Point`**: Represents board coordinates (`x`, `y`) with overridden methods for comparison and display.
- **`Cell`**: Enum for cell states: `X`, `O`, and `EMPTY`.
- **`Board`**: Interface defining essential methods like `initBoard`, `updateBoard`, and `displayBoard`.
- **`TicTacToeBoard`**: Implements `Board` with game-specific logic, including methods to check for wins, draws, and manage empty cells.

##### `players` Package

The `players` subpackage handles player representations, both human and bot:

- **`Player`**: Abstract class managing player symbols and requiring an implementation of the `makeMove` method.
- **`Human`**: Implements human player interaction and move validation.
- **`bot` Subpackage**: Contains bots with varying difficulty levels:
  - **`BooleanPoint`**: Combines a boolean and a `Point` for move decision verification.
  - **`Bot`**: Abstract class for bots with common behaviors, including random move generation.
  - **`EasyBot`**: Low-difficulty bot with random moves.
  - **`MediumBot`**: Intermediate bot with basic strategic moves.
  - **`HardBot`**: Advanced bot using the minimax algorithm for optimal play.
#### `controller.model` Package
The `controller.game` package is responsible for managing the logic and flow of the game. It consists of the following classes:

1. **`CoordinateParser`**: Converts player input into coordinates (`Point`) to locate a position on the board. It validates the format of the entered coordinates and reports errors if needed.

2. **`GameEngine`**: Manages the game's mechanics, including turn control, executing and updating moves, and checking the game status (win, draw, etc.). It also creates players based on the specified type, whether they are humans or bots with various difficulty levels.

3. **`GameController`**: Oversees the main game flow, allowing for starting and controlling games through commands, configuring players, and managing interaction between the user and the system.

This package ensures that the interaction between players, the board, and the game rules is carried out logically and orderly in each game.

## Author

- [Isaúl Tirado](https://github.com/isaultirado77)
