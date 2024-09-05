# Tic-Tac-Toe with AI

## Project Description
...

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


## Author

- [Isaúl Tirado](https://github.com/isaultirado77)
