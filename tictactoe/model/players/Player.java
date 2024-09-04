package tictactoe.model.players;

import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

public abstract class Player {

    protected final Cell mySymbol; // The player symbol can be: 'X' or 'O'
    protected final Cell oppSymbol; // The opppnent player symbol can be: 'X' or 'O'
    protected TicTacToeBoard board;  // Current board of the game;

    public Player(Cell symbol){
        this.mySymbol = symbol;
        this.board = new TicTacToeBoard();
        this.oppSymbol = symbol == Cell.X ? Cell.O : Cell.X;
    }

    public Cell getMySymbol() {
        return mySymbol;
    }

    public Cell getOppSymbol(){
        return oppSymbol;
    }

    public void setBoard(TicTacToeBoard newBoard){
        this.board = newBoard;
    }

    // Abstract method to make a move
    public abstract Point makeMove(TicTacToeBoard board);

    @Override
    public String toString() {
        return mySymbol.getSymbol();
    }
}
