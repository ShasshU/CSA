/*=============================================================================
 |   Assignment:  Recursion Project - Sudoku Solver
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  April 27, 2026 3:30pm
 |
 |  Description:  Solves a 9x9 Sudoku puzzle using recursive backtracking.
 |                Empty cells are represented as 0. The solver scans for the
 |                next empty cell, tries placing digits 1-9, and recurses. If
 |                a placement leads to a dead end it resets the cell back to 0
 |                and tries the next digit (backtracking). Includes two test
 |                cases of different difficulty and uses the Java Time API to
 |                display the current date and time at startup.
 |
 |     Language:  Java 8
 | Ex. Packages:  java.time.LocalDateTime,
 |                java.time.format.DateTimeFormatter
 |
 |   Base case:  When the entire board is scanned and no 0s remain, the puzzle
 |               is solved and we return true.
 |
 | Backtracking:  After placing a number, if the recursive call returns false
 |               we reset that cell to 0 and try the next digit. If none of
 |               1-9 work we return false to the caller.
 |
 |      Failure:  If the starting board has a contradiction (two of the same
 |               number in a row/column/box) the solver returns false because
 |               no valid number will ever fit in a later cell.
 |
 |   Call stack:  Each call handles one empty cell and adds a frame to the
 |               stack. The stack grows as cells get filled and unwinds when
 |               calls return false during backtracking.
 *===========================================================================*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecursionProject {

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {
                    // try placing each number 1-9 in this empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            // backtrack - this number didn't work out
                            board[row][col] = 0;
                        }
                    }
                    // nothing worked in this cell, go back to the previous one
                    return false;
                }
            }
        }
        // base case: no empty cells left, board is solved
        return true;
    }

    // checks if putting num at board[row][col] is allowed
    public static boolean isValid(int[][] board, int row, int col, int num) {
        // check the row
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) return false;
        }

        // check the column
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) return false;
        }

        // check the 3x3 box this cell is in
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }

    // prints the board with lines separating the 3x3 boxes, 0s show as dots
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                if (board[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Java Time API
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        System.out.println("Sudoku Solver - " + now.format(fmt));
        System.out.println("---------------------------------------------");

        // test case 1 - normal difficulty puzzle
        System.out.println("\nTest Case 1 (normal):");

        int[][] board1 = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Before:");
        printBoard(board1);

        long start1 = System.nanoTime();
        boolean solved1 = solveSudoku(board1);
        long end1 = System.nanoTime();

        if (solved1) {
            System.out.println("\nAfter:");
            printBoard(board1);
            System.out.printf("Time: %.3f ms%n", (end1 - start1) / 1_000_000.0);
        } else {
            System.out.println("No solution found.");
        }

        // test case 2 - harder puzzle with way fewer numbers given
        // takes longer because there is a lot more backtracking involved
        System.out.println("\n---------------------------------------------");
        System.out.println("\nTest Case 2 (hard):");

        int[][] board2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 8, 5},
            {0, 0, 1, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 7, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 1, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 7, 3},
            {0, 0, 2, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 9}
        };

        System.out.println("Before:");
        printBoard(board2);

        long start2 = System.nanoTime();
        boolean solved2 = solveSudoku(board2);
        long end2 = System.nanoTime();

        if (solved2) {
            System.out.println("\nAfter:");
            printBoard(board2);
            System.out.printf("Time: %.3f ms%n", (end2 - start2) / 1_000_000.0);
        } else {
            System.out.println("No solution found.");
        }
    }
}
