package tictactoe.controller.game;

import tictactoe.io.Printer;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Bot;
import tictactoe.model.players.Human;
import tictactoe.model.players.Player;

public class GameEngine {

    private final TicTacToeBoard board;
    private final Player human;
    private final Player bot;
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

    public boolean isGameOver(){
        return board.isGameOver();
    }

    private boolean isWin() {
        return board.isWin();
    }

    private boolean isDraw(){
        return board.isDraw();
    }

    public void displayGameState(){
        displayBoardState();
        if (isWin()){
            Printer.println(currentPlayer.toString() + " wins!");
        } else if (isDraw()) {
            Printer.println("Draw!");
        }
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
