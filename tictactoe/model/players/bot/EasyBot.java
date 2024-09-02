package tictactoe.model.players.bot;

import tictactoe.io.IOHandler;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

import java.util.Random;

public class EasyBot {

    public static Point makeMove (TicTacToeBoard board) {
        IOHandler.displayMakeBotMove("\"" + "easy" + "\"");
        while (true) {
            Point coordinate = getRandomCoordinates();

            if (board.isEmptyCell(coordinate.getX(), coordinate.getY())) {
                return coordinate;
            }
        }
    }

    public static Point getRandomCoordinates() {
        int row = generateRandomNumberOnRange();
        int col = generateRandomNumberOnRange();
        return new Point(row, col);
    }

    private static int generateRandomNumberOnRange() {
        Random random = new Random();
        return random.nextInt(3);
    }

}
