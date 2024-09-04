package tictactoe.model.players.bot;

import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;

public class EasyBot extends Bot {

    public EasyBot(Cell mySymbol, String difficulty) {
        super(mySymbol, difficulty);
    }

    @Override
    public Point executeMove() {
        return randomMove();
    }

}
