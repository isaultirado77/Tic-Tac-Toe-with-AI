package tictactoe.model.players;

import tictactoe.io.IOHandler;
import tictactoe.io.IOMessages;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

import java.util.Random;

public class Bot extends Player {

    private final String difficulty;

    public Bot(Cell symbol, String difficulty) {
        super(symbol);
        this.difficulty = difficulty;
    }

    @Override
    public Point makeMove(TicTacToeBoard board) {
        return switch (this.difficulty) {
            case "easy" -> easyDifficulty(board);
            case "medium" -> mediumDifficulty(board);
            case "hard" -> hardDifficulty(board);
            default -> throw new IllegalStateException("Error! "+ IOMessages.BAD_PARAMETERS.getTEXT());
        };
    }

    private Point easyDifficulty(TicTacToeBoard board) {
        IOHandler.displayMakeBotMove("\"" + this.difficulty + "\"");
        while (true) {
            Point coordinate = getRandomCoordinates();

            if (board.isEmptyCell(coordinate.getX(), coordinate.getY())) {
                return coordinate;
            }
        }
    }

    private Point getRandomCoordinates() {
        int row = generateRandomNumberOnRange(0, 2);
        int col = generateRandomNumberOnRange(0, 2);
        return new Point(row, col);
    }

    private Point mediumDifficulty(TicTacToeBoard board) {
        IOHandler.displayMakeBotMove("\"" + this.difficulty + "\"");
        /**
         * writte implementation
         */
        return new Point(0, 0);
    }

    private Point hardDifficulty(TicTacToeBoard board) {
        IOHandler.displayMakeBotMove("\"" + this.difficulty + "\"");
        /**
         * writte implementation
         */
        return new Point(0, 0);
    }

    private int generateRandomNumberOnRange(int lower, int upper) {
        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
}
