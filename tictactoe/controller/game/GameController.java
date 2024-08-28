package tictactoe.controller.game;

public class GameController implements Runnable{

    private GameEngine gameEngine;

    public GameController(){
        gameEngine = new GameEngine();
    }

    @Override
    public void run() {
        gameEngine.initBoardFromPlayerLine();
        gameEngine.displayBoardState();
        gameEngine.getPlayerCoordinate();
        gameEngine.displayBoardState();
    }
}
