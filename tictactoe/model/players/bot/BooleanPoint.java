package tictactoe.model.players.bot;

import tictactoe.model.board.Point;

public class BooleanPoint{

    private final boolean bool;
    private final Point point;

    public BooleanPoint(boolean bool, Point point){
        this.bool = bool;
        this.point = point;
    }

    public boolean getBool(){
        return this.bool;
    }

    public Point getPoint(){
        return this.point;
    }
}
