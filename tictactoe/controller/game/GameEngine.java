package tictactoe.controller.game;

import tictactoe.io.IOHandler;
import tictactoe.io.IOMessages;
import tictactoe.io.Printer;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Human;
import tictactoe.model.players.Player;
import tictactoe.model.players.bot.EasyBot;
import tictactoe.model.players.bot.MediumBot;

public class GameEngine {

    private final TicTacToeBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isPlayer1Turn;


    public GameEngine(String[] players) {
        gameBoard = new TicTacToeBoard();
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
            case "easy" -> new EasyBot(cell, playerType);
            case "medium" -> new MediumBot(cell, playerType);
//            case "hard" -> new Bot(cell, playerType);
            default -> throw new RuntimeException("Error! " + IOMessages.BAD_PARAMETERS.getTEXT());
        };
    }

    public void makeMove() {
        currentPlayer = getCurrentPlayer();

        Point move = currentPlayer.makeMove(gameBoard);

        // Update the game board
        updateGameBoard(move);

        // Update board of the current player
        currentPlayer.setBoard(gameBoard);
    }

    public boolean isGameOver() {
        return gameBoard.isGameOver();
    }

    private boolean isWin() {
        return gameBoard.isWin();
    }

    private boolean isDraw() {
        return gameBoard.isDraw();
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

    private void updateGameBoard(Point p) {
        gameBoard.updateBoard(p.getX(), p.getY(), currentPlayer.getMySymbol());
    }

    public void displayBoardState() {
        gameBoard.displayBoard();
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
