package tictactoe.controller.game;

import tictactoe.io.IOHandler;
import tictactoe.io.IOMessages;
import tictactoe.io.Printer;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Human;
import tictactoe.model.players.Player;
import tictactoe.model.players.bot.Bot;

public class GameEngine {

    private final TicTacToeBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isPlayer1Turn;


    public GameEngine(String[] players) {
        board = new TicTacToeBoard();
        isPlayer1Turn = true;

        try {
            player1 = createPlayer(players[1], Cell.X);
            player2 = createPlayer(players[2], Cell.O);
        }catch (RuntimeException e){
            player1 = null;
            player2 = null;
            Printer.println(e.getMessage());
        }
    }

    private Player createPlayer(String playerType, Cell cell) {
        return switch (playerType.toLowerCase()) {
            case "user" -> new Human(cell);
            case "easy" -> new Bot(cell, playerType);
            case "medium" -> new Bot(cell, playerType);
//            case "hard" -> new Bot(cell, playerType);
            default -> throw new RuntimeException("Error! " + IOMessages.BAD_PARAMETERS.getTEXT());
        };
    }

    public void makeMove() {
        if (player1 == null || player2 == null) {
            return;
        }
        currentPlayer = getCurrentPlayer();
        Point move = currentPlayer.makeMove(board);
        updateBoard(move);
    }

    public boolean isGameOver() {
        return board.isGameOver();
    }

    private boolean isWin() {
        return board.isWin();
    }

    private boolean isDraw() {
        return board.isDraw();
    }

    public void displayGameState() {
        displayBoardState();
        IOHandler.displayGameState(isWin(), isDraw(), currentPlayer.toString());
    }

    public void switchTurns() {
        isPlayer1Turn = !isPlayer1Turn;
    }

    public Player getCurrentPlayer() {
        return isPlayer1Turn ? player1 : player2;
    }

    private void updateBoard(Point p) {
        board.updateBoard(p.getX(), p.getY(), currentPlayer.getSymbol());
    }

    public void displayBoardState() {
        board.displayBoard();
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
