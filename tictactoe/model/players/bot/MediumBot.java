package tictactoe.model.players.bot;

import tictactoe.io.IOHandler;
import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;
import tictactoe.model.board.TicTacToeBoard;

public class MediumBot {

    public static Point makeMove(TicTacToeBoard board, Cell symbol) {
        IOHandler.displayMakeBotMove("\"" + "medium" + "\"");

        // 1. Try to win by making a move that completes three in a row
        BooleanPoint winMove = findWinningMove(board, symbol);
        if (winMove.getBool()) {
            return winMove.getPoint();
        }

        // 2. Try to block opponent's winning move
        Cell opponentSymbol = getOpponentCell(symbol);
        BooleanPoint blockMove = findWinningMove(board, opponentSymbol);
        if (blockMove.getBool()) {
            return blockMove.getPoint();
        }

        // 3. Otherwise, make a random move
        return makeRandomMove(board);
    }


    private static BooleanPoint findWinningMove(TicTacToeBoard board, Cell symbol) {
        BooleanPoint move = isTwoInRow(board, symbol);
        if (move.getBool()) return move;

        move = isTwoInCol(board, symbol);
        if (move.getBool()) return move;

        move = isTwoInMainDiag(board, symbol);
        if (move.getBool()) return move;

        move = isTwoInSecondaryDiag(board, symbol);
        return move;
    }


    private static Cell getOpponentCell(Cell botCell) {
        return botCell == Cell.X ? Cell.O : Cell.X;
    }

    private static BooleanPoint isTwoInRow(TicTacToeBoard board, Cell symbol) {
        for (int row = 0; row < board.ROWS; row++) {
            for (int col = 0; col < board.COLS - 2; col++) {

                // Verify the configuration ( empty symbol symbol )
                if (board.getCellState(row, col) == Cell.EMPTY &&
                        board.getCellState(row, col + 1) == symbol &&
                        board.getCellState(row, col + 2) == symbol) {

                    // Return true and the coordinate of the empty cell
                    return new BooleanPoint(true, new Point(row, col));
                }

                // Verify the configuration ( symbol symbol empty )
                if (board.getCellState(row, col) == symbol &&
                        board.getCellState(row, col + 1) == symbol &&
                        board.getCellState(row, col + 2) == Cell.EMPTY) {

                    // Return true and the coordinate of the empty cell
                    return new BooleanPoint(true, new Point(row, col + 2));
                }
            }
        }
        return new BooleanPoint(false, new Point(-1, -1));
    }

    private static BooleanPoint isTwoInCol(TicTacToeBoard board, Cell symbol) {
        for (int col = 0; col < board.COLS; col++) {
            for (int row = 0; row < board.ROWS - 2; row++) {

                // Verify the configuration ( empty symbol symbol )
                if (board.getCellState(row, col) == Cell.EMPTY &&
                        board.getCellState(row + 1, col) == symbol &&
                        board.getCellState(row + 1, col) == symbol) {

                    // Return true and the coordinate of the empty cell
                    return new BooleanPoint(true, new Point(row, col));
                }

                // Verify the configuration ( symbol symbol empty )
                if (board.getCellState(row, col) == symbol &&
                        board.getCellState(row + 1, col) == symbol &&
                        board.getCellState(row + 2, col) == Cell.EMPTY) {

                    // Return true and the coordinate of the empty cell
                    return new BooleanPoint(true, new Point(row + 2, col));
                }
            }
        }
        return new BooleanPoint(false, new Point(-1, -1));
    }

    private static BooleanPoint isTwoInMainDiag(TicTacToeBoard board, Cell symbol) {
        // Validate center cell first
        if (board.getCellState(1, 1) != symbol) {
            return new BooleanPoint(false, new Point(-1, -1));
        }

        // Verify the configuration ( empty, symbol, symbol )
        if (board.isEmptyCell(0, 0) && board.getCellState(2, 2) == symbol) {
            return new BooleanPoint(true, new Point(0, 0));
        }

        // Verify the configuration ( symbol, symbol, empty )
        if (board.getCellState(0, 0) == symbol && board.isEmptyCell(2, 2)) {
            return new BooleanPoint(true, new Point(2, 2));
        }

        // Verify the configuration ( empty, symbol, symbol ) on the inverse diagonal
        if (board.isEmptyCell(2, 2) && board.getCellState(0, 0) == symbol) {
            return new BooleanPoint(true, new Point(2, 2));
        }

        // Verify the configuration ( symbol, symbol, empty ) on the inverse diagonal
        if (board.getCellState(2, 2) == symbol && board.isEmptyCell(0, 0)) {
            return new BooleanPoint(true, new Point(0, 0));
        }

        return new BooleanPoint(false, new Point(-1, -1));
    }

    private static BooleanPoint isTwoInSecondaryDiag(TicTacToeBoard board, Cell symbol) {
        // Validate center cell first
        if (board.getCellState(1, 1) != symbol) {
            return new BooleanPoint(false, new Point(-1, -1));
        }

        // Verify the configuration ( empty, symbol, symbol )
        if (board.isEmptyCell(0, 2) && board.getCellState(2, 0) == symbol) {
            return new BooleanPoint(true, new Point(0, 2));
        }

        // Verify the configuration ( symbol, symbol, empty )
        if (board.getCellState(0, 2) == symbol && board.isEmptyCell(2, 0)) {
            return new BooleanPoint(true, new Point(2, 0));
        }

        // Verify the configuration ( empty, symbol, symbol )
        if (board.isEmptyCell(2, 0) && board.getCellState(0, 2) == symbol) {
            return new BooleanPoint(true, new Point(2, 0));
        }

        // Verify the configuration ( symbol, symbol, empty )
        if (board.getCellState(2, 0) == symbol && board.isEmptyCell(0, 2)) {
            return new BooleanPoint(true, new Point(0, 2));
        }

        return new BooleanPoint(false, new Point(-1, -1));
    }

    private static Point makeRandomMove(TicTacToeBoard board) {
        return EasyBot.makeMove(board);
    }
}
