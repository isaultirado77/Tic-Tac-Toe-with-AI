package tictactoe.io;

import java.util.Scanner;

public class IOHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readNextLine() {
        return scanner.nextLine();
    }

    @SuppressWarnings("unused")
    public static int readInteger() {
        try {
            return Integer.parseInt(readNextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @SuppressWarnings("unused")
    public static Scanner getScanner(){
        return scanner;
    }

    @SuppressWarnings("unused")
    public static String promptEnterTheCells(){
        Printer.print(IOMessages.ENTER_THE_CELLS.getTEXT());
        return readNextLine();
    }

    public static void displayErrorCoordinates(){
        Printer.println(IOMessages.ERROR_COORDINATES.getTEXT());
    }

    public static void displayErrorInvalidFormat(){
        Printer.println(IOMessages.ERROR_INVALID_FORMAT.getTEXT());
    }

    public static void displayErrorOcupedCell(){
        Printer.println(IOMessages.ERROR_OCCUPIED_CELL.getTEXT());
    }

    public static String promptEnterTheCoordinates(){
        Printer.print(IOMessages.ENTER_THE_COORDINATES.getTEXT());
        return readNextLine();
    }

    public static void displayGameState(boolean isWin, boolean isDraw, String winner){
        if (isWin){
            Printer.println(winner + IOMessages.WIN.getTEXT());
        } else if (isDraw) {
            Printer.println(IOMessages.DRAW.getTEXT());
        }
    }

    public static void displayMakeBotMove(String difficulty){
        Printer.println(IOMessages.MAKE_BOT_MOVE.getTEXT() + difficulty);
    }

    public static String promptInputTheCommand() {
        Printer.print(IOMessages.INPUT_COMMAND.getTEXT());
        return readNextLine();
    }

    public static void displayBadParameters() {
        Printer.println(IOMessages.BAD_PARAMETERS.getTEXT());
    }
}
