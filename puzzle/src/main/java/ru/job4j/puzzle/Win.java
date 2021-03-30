package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                result = (winHorizontal(board, i) || winVertical(board, i));
                break;
            }
        }
        return result;
    }

    private static boolean winVertical(int[][] board, int columb) {
        boolean result = true;
        for (int[] ints : board) {
            if (ints[columb] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean winHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

}
