package tictactoe.model.players.bot;

import tictactoe.model.board.Cell;
import tictactoe.model.board.Point;

import java.util.ArrayList;
import java.util.List;

//* This player generate a move with the executeMove method using Minimax algorithm */
public class HardBot extends Bot{

    public HardBot(Cell mySymbol, String difficulty){
        super(mySymbol, difficulty);
    }
    /** Get next best move for computer. Return int[2] of {row, col} */
    @Override
    public Point executeMove(){
        int[] result = minimax(2, mySymbol);
        return new Point(result[1], result[2]);
    }

    /** Recursive minimax at level of depth for either maximizing or minimizing player.
     Return int[3] of {score, row, col}  */
    private int[] minimax(int depth, Cell playerSymbol){
        // Generate possible next moves in a list of Points {row, col}
        List<Point> nextMoves = generateMoves();

        // mySeed is maximizing; while oppSeed is minimizing
        int bestScore = (playerSymbol == mySymbol) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0){
            // Gameover or depth reached, evaluate score
            bestScore = evaluate();
        }
        else {
            for (Point move : nextMoves) {
                // Try this move for the current "player"
                board.updateBoard(move.getX(), move.getY(), playerSymbol);
                if (playerSymbol == mySymbol){ // mySymbol is maximizing player
                    currentScore = minimax(depth -1, oppSymbol)[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = move.getX();
                        bestCol = move.getY();
                    }
                } else { // oppSymbol is minimizing player
                    currentScore = minimax(depth - 1, mySymbol)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestRow = move.getX();
                        bestCol = move.getY();
                    }
                }
                // Undo the move
                board.updateBoard(move.getX(), move.getY(), Cell.EMPTY);
            }
        }
        return new int[] {bestScore, bestRow, bestCol};
    }

    private List<Point> generateMoves() {
        // If is game-over i.e., no next move
        if(board.isGameOver()){
            return new ArrayList<>();
        }
        return board.getEmptyCells();
    }

    private int evaluate(){
        int score = 0;
        // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
        score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
        score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
        return score;
    }


    /** The heuristic evaluation function for the given line of 3 cells
     @Return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer.
     -100, -10, -1 for 3-, 2-, 1-in-a-line for opponent.
     0 otherwise */
    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        // First cell
        if (board.getCellState(row1,col1) == mySymbol) {
            score = 1;
        } else if (board.getCellState(row1,col1) == oppSymbol) {
            score = -1;
        }

        // Second cell
        if (board.getCellState(row2,col2) == mySymbol) {
            if (score == 1) {   // cell1 is mySeed
                score = 10;
            } else if (score == -1) {  // cell1 is oppSeed
                return 0;
            } else {  // cell1 is empty
                score = 1;
            }
        } else if (board.getCellState(row2,col2) == oppSymbol) {
            if (score == -1) { // cell1 is oppSeed
                score = -10;
            } else if (score == 1) { // cell1 is mySeed
                return 0;
            } else {  // cell1 is empty
                score = -1;
            }
        }

        // Third cell
        if (board.getCellState(row3,col3) ==  mySymbol) {
            if (score > 0) {  // cell1 and/or cell2 is mySeed
                score *= 10;
            } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = 1;
            }
        } else if (board.getCellState(row2,col2) == oppSymbol) {
            if (score < 0) {  // cell1 and/or cell2 is oppSeed
                score *= 10;
            } else if (score > 1) {  // cell1 and/or cell2 is mySeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = -1;
            }
        }
        return score;
    }

}
