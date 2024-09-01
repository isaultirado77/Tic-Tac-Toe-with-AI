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
    public Cell getCellState(int row, int col){
        return board[row][col];
    }

    public boolean isEmptyCell(int row, int col){
        return board[row][col].equals(Cell.EMPTY);
    }

    @Override
    public void resetBoard() {
        initBoard();
    }
}
