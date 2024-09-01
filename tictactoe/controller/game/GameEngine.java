package tictactoe.controller.game;

import tictactoe.model.board.Cell;
import tictactoe.model.board.TicTacToeBoard;

public class GameEngine {

    private TicTacToeBoard board;

    private Cell currentPlayer;

    public GameEngine() {
        board = new TicTacToeBoard();
    }

    public void displayBoardState() {
        board.displayBoard();
    }

    public Cell getCurrentPlayer() {
        return currentPlayer;
    }

}
