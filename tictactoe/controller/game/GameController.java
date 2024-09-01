package tictactoe.controller.game;

import tictactoe.io.IOHandler;

public class GameController {

    private final GameEngine gameEngine;

    public GameController() {
        gameEngine = new GameEngine();
    }

    public void start(){
        while (true){
            String command = IOHandler.promptInputTheComand();

            if (command.equalsIgnoreCase("exit")){
                break;
            }
            run();
        }
    }

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

    private void handleCommandAction(String command){

    }
}
