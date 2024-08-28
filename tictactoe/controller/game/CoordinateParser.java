package tictactoe.controller.game;

import tictactoe.io.Printer;
import tictactoe.model.board.Point;

public class CoordinateParser {

    public static Point parse(String line) {
        String[] parts = line.split(" ");

        if (parts.length != 2) {
            // Si no hay exactamente dos partes, es un formato inválido.
            return new Point(-2, -2);
        }

        try {
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if (isValidCoordinate(row) && isValidCoordinate(col)) {
                return new Point(row, col);
            } else {
                return new Point(-1, -1);
            }
        } catch (NumberFormatException e) {
            // Si la entrada no es un número, regresa el código de error -2
            return new Point(-2, -2);
        }
    }

    private static boolean isValidCoordinate(int coord) {
        return coord >= 1 && coord <= 3;
    }
}

