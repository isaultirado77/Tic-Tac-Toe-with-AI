package tictactoe.model.players;

import tictactoe.model.board.Board;
import tictactoe.model.board.Cell;

public abstract class Player {

    private Cell symbol; // The player symbol can be: 'X' or 'O'

    public Player(Cell symbol){
        this.symbol = symbol;
    }

    public Cell getSymbol() {
        return symbol;
    }

    // Abstract method to make a move
    public abstract void makeMove(Board board);

}
