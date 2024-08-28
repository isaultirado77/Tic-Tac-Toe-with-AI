package tictactoe.io;

import java.util.Scanner;

public class IOHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readNextLine() {
        return scanner.nextLine();
    }

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
        Printer.println(IOMessages.ENTER_THE_CELLS.getTEXT());
    }

    public static String prompEnterTheCoordinates(){
        Printer.print(IOMessages.ENTER_THE_COORDINATES.getTEXT());
        return readNextLine();
    }
}
