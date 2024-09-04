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
            if (gameEngine.getPlayer1() != null && gameEngine.getPlayer2() != null) {
                run();
            }
        }
    }

    public void run() {
        while (true) {
            if (gameEngine.getPlayer1() == null ||gameEngine.getPlayer2() == null) {
                break;
            }
            gameEngine.displayBoardState();
            gameEngine.makeMove();
            if (gameEngine.isGameOver()) {
                gameEngine.displayGameState();
                break;
            }
            gameEngine.switchTurns();
        }
    }
}
