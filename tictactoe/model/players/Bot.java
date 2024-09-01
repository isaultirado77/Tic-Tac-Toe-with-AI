package tictactoe.model.players;

import tictactoe.io.IOHandler;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

import java.util.Random;

public class Bot extends Player {

    public Bot(Cell symbol) {
        super(symbol);
    }

    @Override
    public Point makeMove(TicTacToeBoard board) {
        return easyDifficulty(board);
    }

    private Point easyDifficulty(TicTacToeBoard board) {
        String difficulty = "\"easy\"";
        IOHandler.displayMakeBotMove(difficulty);
        while (true){
            Point coordinate = getCoordinatesEasyDifficulty();

            if(board.isEmptyCell(coordinate.getX(), coordinate.getY())){
                return coordinate;
            }
        }
    }

    private Point getCoordinatesEasyDifficulty(){
        int row = generateRandomNumberOnRange(0, 2);
        int col = generateRandomNumberOnRange(0, 2);
        return new Point(row, col);
    }

    private int generateRandomNumberOnRange(int lower, int upper) {
        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
}
