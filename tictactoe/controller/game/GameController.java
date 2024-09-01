package tictactoe.controller.game;

public class GameController implements Runnable {

    private final GameEngine gameEngine;

    public GameController() {
        gameEngine = new GameEngine();
    }

    @Override
    public void run() {
        while (!gameEngine.isGameOver()){
            gameEngine.displayBoardState();
            gameEngine.makeMove();
            gameEngine.switchTurns();
        }
    }
}
