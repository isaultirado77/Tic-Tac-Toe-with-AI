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
            if (coordinate.getX() == -1 || coordinate.getY() == -1) {
                Printer.println("Error! Coordinates should be from 1 to 3!");
            } else if (coordinate.getX() == -2 || coordinate.getY() == -2) {
                Printer.println("Error! Invalid number format. You should enter numbers!");
            } else if (!board.isEmptyCell(coordinate.getX() - 1, coordinate.getY() - 1)) {
                Printer.println("Error! This cell is occupied! Choose another one!");
            } else {
                board.updateBoard(coordinate.getX() - 1, coordinate.getY() - 1, Cell.X);
                System.out.println(coordinate.toString());
                return;
            }
        }
    }

    public void handleUserIntCoordinate(Point p){
        if (p.getX() == -1 || p.getY() == -1) {
            IOHandler.displayErrorCoordinates();
        } else if (p.getX() == -2 || p.getY() == -2) {
            IOHandler.displayErrorInvalidFormat();
        } else if (!board.isEmptyCell(p.getX() - 1, p.getY() - 1)) {
            IOHandler.displayErrorOcupedCell();
        } else {
            board.updateBoard(p.getX() - 1, p.getY() - 1, Cell.X);
            System.out.println(p.toString());
        }
    }


    private String getLineCoordinate() {
        return IOHandler.prompEnterTheCoordinates();
    }

    private boolean isValidUserCoordinate(Point point) {
        return point.getX() > 0 && point.getY() > 0;
    }

    public void displayBoardState() {
        board.displayBoard();
    }

}
