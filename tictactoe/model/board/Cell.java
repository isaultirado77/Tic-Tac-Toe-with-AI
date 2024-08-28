package tictactoe.model.board;

public enum Cell {

    X("X"),
    O("O"),
    EMPTY(" ");

    private String symbol;

    Cell(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }
}
