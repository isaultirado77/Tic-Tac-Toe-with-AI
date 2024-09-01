package tictactoe.model.board;

public interface Board {

    void initBoard();
    void updateBoard(int row, int col, Cell cell);
    void displayBoard();

    Cell getCellState(int row, int col);

    boolean isGameOver();

    boolean isEmptyCell(int row, int col);

    void resetBoard();
}
