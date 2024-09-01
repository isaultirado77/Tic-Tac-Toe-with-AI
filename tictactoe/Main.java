package tictactoe;

import tictactoe.controller.game.GameController;

public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }

}
