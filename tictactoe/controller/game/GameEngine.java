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

    public void initBoardFromPlayerLine() {
        String boardState = getBoardStateFromPlayerLine();
        board.initBoardFromCells(boardState);
    }

    private String getBoardStateFromPlayerLine() {
        return IOHandler.promptEnterTheCells();
    }

    private String getLineCoordinate() {
        return IOHandler.prompEnterTheCoordinates();
    }

    public Point getPlayerCoordinate() {
        while (true) {
            String lineCoordinate = getLineCoordinate();
            Point coordinate = CoordinateParser.parse(lineCoordinate);
            if (handlePlayerIntCoordinate(coordinate)) {
                return coordinate;
            }
        }
    }

    private Cell getNextPlayer() {
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                if (board.getCellState(i, j) == Cell.X) {
                    countX++;
                } else if (board.getCellState(i, j) == Cell.O) {
                    countO++;
                }
            }
        }

        return countX > countO ? Cell.O : Cell.X;
    }

    private boolean handlePlayerIntCoordinate(Point p) {
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
            board.updateBoard(p.getX() - 1, p.getY() - 1, getNextPlayer());
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

    public boolean isGameOver() {
        return board.isGameOver();
    }

    public void displayBoardState() {
        board.displayBoard();
    }

}
