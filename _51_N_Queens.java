import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_N_Queens {

      static void  solve(char[][] board ,int row, int n, List<List<String>> ans){

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }


        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = 'Q';
                solve(board, row+1, n, ans);
                board[row][col] = '.';
            }
        }
     }

     static boolean isSafe(char[][] board, int n, int row, int col){
        //check same column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check same row
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        //check left-upper diagonal
        for (int i = row - 1,  j = col - 1;
            i >= 0 && j >= 0; i--,j--
        ) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //check right-upper diagonal
        for (int i = row - 1, j = col + 1; i>= 0 && j< n; i--,j++) {
          if (board[i][j] == 'Q') {
            return false;
          }  
        }

        return true;
     }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        
        solve(board, 0, n, ans);

        return ans;
    }

    

    public static void main(String[] args){
        System.out.println(solveNQueens(4));
    }
}
