package tictactoe.controller.game;

import tictactoe.model.board.Cell;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Bot;
import tictactoe.model.players.Human;
import tictactoe.model.players.Player;

public class GameEngine {

    private TicTacToeBoard board;
    private Player human;
    private Player bot;
    public GameEngine() {
        board = new TicTacToeBoard();
        human = new Human(Cell.X);
        bot = new Bot(Cell.O);
    }


    private boolean isGameOver() {
        return board.isGameOver();
    }

    private boolean isGameNotFinished() {
        return board.hasEmptyCells();
    }

    public void displayBoardState() {
        board.displayBoard();
    }
}
