package tictactoe.controller.game;

import tictactoe.io.IOHandler;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

public class GameEngine {

    private TicTacToeBoard board;

    public GameEngine() {
        board = new TicTacToeBoard();
    }

    public void initBoardFromUserLine() {
        String boardState = getBoardStateFromUserLine();
        board.initBoardFromCells(boardState);
    }

    private String getBoardStateFromUserLine() {
        return IOHandler.promptEnterTheCells();
    }

    private String getLineCoordinate() {
        return IOHandler.prompEnterTheCoordinates();
    }

    public Point getUserIntCoordinate() {
        while (true) {
            String lineCoordinate = getLineCoordinate();
            Point coordinate = CoordinateParser.parse(lineCoordinate);
            if (handleUserIntCoordinate(coordinate)) {
                return coordinate;
            }
        }
    }

    private boolean handleUserIntCoordinate(Point p) {
        if (isCoordinateOutOfRange(p)) {
            IOHandler.displayErrorCoordinates();
            return false;
        } else if (isCoordinateInvalidFormat(p)) {
            IOHandler.displayErrorInvalidFormat();
            return false;
        } else if (isCellOccupied(p)) {
            IOHandler.displayErrorOcupedCell();
            return false;
        } else {
            board.updateBoard(p.getX() - 1, p.getY() - 1, Cell.X);
            return true;
        }
    }

    private boolean isCoordinateOutOfRange(Point p) {
        return p.getX() == -1 || p.getY() == -1;
    }

    private boolean isCoordinateInvalidFormat(Point p) {
        return p.getX() == -2 || p.getY() == -2;
    }

    private boolean isCellOccupied(Point p) {
        return !board.isEmptyCell(p.getX() - 1, p.getY() - 1);
    }


    public void displayBoardState() {
        board.displayBoard();
    }

}
