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
    private boolean isHumanTurn;

    public GameEngine() {
        board = new TicTacToeBoard();
        human = new Human(Cell.X);
        bot = new Bot(Cell.O);
        isHumanTurn = true;
    }

    private boolean isGameOver() {
        return board.isGameOver();
    }

    public void switchTurns(){
        isHumanTurn =! isHumanTurn;
    }

    public Cell getCurrentPlayer(){
        return isHumanTurn ? human.getSymbol() : bot.getSymbol();
    }

    public void displayBoardState() {
        board.displayBoard();
    }
}
