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

    public static Scanner getScanner(){
        return scanner;
    }
}
