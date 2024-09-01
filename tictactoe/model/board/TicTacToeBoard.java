package tictactoe.model.board;

import tictactoe.io.Printer;

public class TicTacToeBoard implements Board {

    public final int ROWS = 3;
    public final int COLS = 3;
    private Cell[][] board;

    public TicTacToeBoard() {
        board = new Cell[ROWS][COLS];
        initBoard();
    }

    @Override
    public void initBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
    }

    public void initBoardFromCells(String cell) {
        int cellIndex = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = getCellFromChar(cell.charAt(cellIndex));
                cellIndex++;
            }
        }
    }

    private Cell getCellFromChar(char c) {
        return switch (c) {
            case 'X' -> Cell.X;
            case 'O' -> Cell.O;
            default -> Cell.EMPTY;
        };
    }

    @Override
    public void updateBoard(int row, int col, Cell cell) {
        this.board[row][col] = cell;
    }

    @Override
    public void displayBoard() {
        Printer.println("---------");
        for (int i = 0; i < ROWS; i++) {
            Printer.print("| ");
            for (int j = 0; j < COLS; j++) {
                Printer.print(board[i][j].getSymbol() + " ");
            }
            Printer.print("|\n");
        }
        Printer.print("---------\n");
    }

    @Override
    public Cell getCellState(int row, int col) {
        return board[row][col];
    }

    private boolean isVerticalWin() {
        for (int col = 0; col < COLS; col++) {
            Cell firstCell = getCellState(0, col); // Get the superior cell of the current column

            if (firstCell != Cell.EMPTY) { // Only if the first cell isn't empty!
                boolean win = true; // Check this column
                // Verify if all the cells in the current column are on the same state
                for (int row = 1; row < ROWS; row++) {
                    if (getCellState(row, col) != firstCell) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true; // Found a winning column
                }
            }
        }
        return false; // No winning column found
    }


    private boolean isHorizontalWin() {
        for (int row = 0; row < ROWS; row++) {
            Cell firstCell = getCellState(row, 0); // Get the cell on the left column

            if (firstCell != Cell.EMPTY) { // Only if the first cell isn't empty!
                boolean win = true; // Check this row
                // Verify if all the cells in the current row are on the same state
                for (int col = 1; col < COLS; col++) {
                    if (getCellState(row, col) != firstCell) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true; // Found a winning row
                }
            }
        }
        return false; // No winning row found
    }

    private boolean isDiagonalWin() {
        boolean mainDiagonal = board[0][0] == board[1][1] && board[1][1] == board[2][2];
        boolean secondDiagonal = board[0][2] == board[1][1] && board[1][1] == board[2][0];
        return mainDiagonal || secondDiagonal;
    }

    @Override
    public boolean isGameOver() {
        System.out.println(isVerticalWin());
        System.out.println(isHorizontalWin());
        System.out.println(isDiagonalWin());
        return isVerticalWin() || isHorizontalWin() || isDiagonalWin();
    }

    @Override
    public boolean hasEmptyCells() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (getCellState(i, j) == Cell.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmptyCell(int row, int col) {
        return board[row][col].equals(Cell.EMPTY);
    }

    @Override
    public void resetBoard() {
        initBoard();
    }
}
