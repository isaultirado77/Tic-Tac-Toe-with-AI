package tictactoe.controller.game;

import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Bot;
import tictactoe.model.players.Human;
import tictactoe.model.players.Player;

public class GameEngine {

    private TicTacToeBoard board;
    private Player human;
    private Player bot;
    private Player currentPlayer;
    private boolean isHumanTurn;

    public GameEngine() {
        board = new TicTacToeBoard();
        human = new Human(Cell.X);
        bot = new Bot(Cell.O);
        isHumanTurn = true;
    }

    public void makeMove(){
        currentPlayer = getCurrentPlayer();
        Point move = currentPlayer.makeMove(board);
        updateBoard(move);
    }

    public boolean isGameOver() {
        return board.isGameOver();
    }

    public void switchTurns(){
        isHumanTurn =! isHumanTurn;
    }

    public Player getCurrentPlayer(){
        return isHumanTurn ? human : bot;
    }

    private void updateBoard(Point p){
        board.updateBoard(p.getX(), p.getY(), currentPlayer.getSymbol());
    }

    public void displayBoardState() {
        board.displayBoard();
    }
}
