package tictactoe.controller.game;

import tictactoe.io.IOHandler;
import tictactoe.io.Printer;
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

    public void getUserIntCoordinate() {
        while (true) {
            String lineCoordinate = getLineCoordinate();
            Point coordinate = CoordinateParser.parse(lineCoordinate);
            if (isCoordinateOutOfRange(coordinate)) {
                IOHandler.displayErrorCoordinates();
            } else if (isCoordinateInvalidFormat(coordinate)) {
                IOHandler.displayErrorInvalidFormat();
            } else if (isCellOccupied(coordinate)) {
                IOHandler.displayErrorOcupedCell();
            } else {
                board.updateBoard(coordinate.getX() - 1, coordinate.getY() - 1, Cell.X);
                System.out.println(coordinate.toString());
                return;
            }
        }
    }

    private String getLineCoordinate() {
        return IOHandler.prompEnterTheCoordinates();
    }

    private boolean isValidCoordinate(Point p) {
        return !isCoordinateOutOfRange(p) &&
                !isCoordinateInvalidFormat(p) &&
                !isCellOccupied(p);
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
