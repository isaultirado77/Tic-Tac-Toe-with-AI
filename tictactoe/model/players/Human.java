package tictactoe.model.players;

import tictactoe.controller.game.CoordinateParser;
import tictactoe.io.IOHandler;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

public class Human extends Player{

    public Human(Cell symbol){
        super(symbol);

    }

    @Override
    public Point makeMove(TicTacToeBoard board) {
        return getPlayerCoordinate(board);
    }

    private Point getPlayerCoordinate(TicTacToeBoard board){
        while (true) {
            String lineCoordinate = getLineCoordinate();
            Point coordinate = CoordinateParser.parse(lineCoordinate);
            if (handlePlayerIntCoordinate(coordinate, board)) {
                return parseToBoardCoordinate(coordinate);
            }
        }
    }

    private Point parseToBoardCoordinate(Point p){
        return new Point(p.getX() -1, p.getY() -1);
    }

    private String getLineCoordinate() {
        return IOHandler.promptEnterTheCoordinates();
    }

    private boolean handlePlayerIntCoordinate(Point p, TicTacToeBoard board) {
        if (isCoordinateOutOfRange(p)) {
            IOHandler.displayErrorCoordinates();
            return false;
        } else if (isCoordinateInvalidFormat(p)) {
            IOHandler.displayErrorInvalidFormat();
            return false;
        } else if (isCellOccupied(p, board)) {
            IOHandler.displayErrorOccupedCell();
            return false;
        } else {
            return true;
        }
    }

    private boolean isCoordinateOutOfRange(Point p) {
        return p.getX() == -1 || p.getY() == -1;
    }

    private boolean isCoordinateInvalidFormat(Point p) {
        return p.getX() == -2 || p.getY() == -2;
    }

    private boolean isCellOccupied(Point p, TicTacToeBoard board) {
        return !board.isEmptyCell(p.getX() - 1, p.getY() - 1);
    }
}
