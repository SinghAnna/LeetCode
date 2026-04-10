import java.util.Arrays;

public class _52_TotalNoNQueen {

    boolean isSafe(char[][] board, int n, int row, int col) {

        // column check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // right upper diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public int solveNoQueen(char[][] board, int n, int row) {

        //  base case
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = 'Q';
                count += solveNoQueen(board, n, row + 1);
                board[row][col] = '.';
            } 
        }

        return count;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return solveNoQueen(board, n, 0);
    }

    public static void main(String[] args) {
        _52_TotalNoNQueen obj = new _52_TotalNoNQueen();
        System.out.println(obj.totalNQueens(4)); // Output: 2
    }
}
