package tictactoe.model.players.bot;

import tictactoe.io.IOHandler;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Player;

import java.util.Random;

public abstract class Bot extends Player {

    protected final String difficulty;

    public Bot(Cell mySymbol, String difficulty) {
        super(mySymbol);
        this.difficulty = difficulty;
    }

    @Override
    public Point makeMove(TicTacToeBoard currentBoard) {
        setBoard(currentBoard);
        IOHandler.displayMakeBotMove(difficulty);
        return executeMove();
    }

    // Abstract method to execute the move with specific algorithm
    public abstract Point executeMove();

    // Protected method to make a random move
    protected Point randomMove() {
        while (true) {
            Point coordinate = getRandomCoordinates();

            if (board.isEmptyCell(coordinate.getX(), coordinate.getY())) {
                return coordinate;
            }
        }
    }

    private Point getRandomCoordinates() {
        int row = generateRandomNumber();
        int col = generateRandomNumber();
        return new Point(row, col);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(3);
    }
}
