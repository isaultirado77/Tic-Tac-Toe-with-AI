package tictactoe.controller.game;

public class GameController implements Runnable {

    private final GameEngine gameEngine;

    public GameController() {
        gameEngine = new GameEngine();
    }

    @Override
    public void run() {
        while (true){
            gameEngine.displayBoardState();
            gameEngine.makeMove();
            if (gameEngine.isGameOver()){
                gameEngine.displayGameState();
                break;
            }
            gameEngine.switchTurns();
        }
    }
}
