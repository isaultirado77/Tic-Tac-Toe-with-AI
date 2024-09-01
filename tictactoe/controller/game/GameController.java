package tictactoe.controller.game;

import tictactoe.io.IOHandler;

public class GameController {

    private GameEngine gameEngine;

    public void start() {
        while (true) {
            String command = IOHandler.promptInputTheCommand();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            handleCommandAction(command);
        }
    }

    private void handleCommandAction(String command) {
        String[] split = command.split(" ");

        if (split.length != 3) {
            IOHandler.displayBadParameters();
        } else {
            gameEngine = new GameEngine(split);
            run();
        }
    }

    public void run() {
        while (true) {
            gameEngine.displayBoardState();
            gameEngine.makeMove();
            if (gameEngine.isGameOver()) {
                gameEngine.displayGameState();
                break;
            } else if (gameEngine.getPlayer1() == null ||gameEngine.getPlayer2() == null) {
                break;
            }
            gameEngine.switchTurns();
        }
    }
}
