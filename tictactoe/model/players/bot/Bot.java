package tictactoe.model.players.bot;

import tictactoe.io.IOHandler;
import tictactoe.io.IOMessages;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;
import tictactoe.model.players.Player;

public class Bot extends Player {

    private final String difficulty;

    public Bot(Cell symbol, String difficulty) {
        super(symbol);
        this.difficulty = difficulty;
    }

    @Override
    public Point makeMove(TicTacToeBoard board) {
        return switch (difficulty) {
            case "easy" -> {
                IOHandler.displayMakeBotMove(difficulty);
                yield EasyBot.makeMove(board);
            }
            case "medium" -> {
                IOHandler.displayMakeBotMove(difficulty);
                yield MediumBot.makeMove(board, getSymbol());
            }
            default -> throw new IllegalStateException("Error! " + IOMessages.BAD_PARAMETERS.getTEXT());
        };
    }

}
