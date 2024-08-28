package tictactoe.controller.game;

public class GameController implements Runnable{

    private GameEngine gameEngine;

    public GameController(){
        gameEngine = new GameEngine();
    }

    @Override
    public void run() {
        gameEngine.initBoardFromUserLine();
        gameEngine.displayBoardState();
        gameEngine.getUserIntCoordinate();
        gameEngine.displayBoardState();
    }
}
