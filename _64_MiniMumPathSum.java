public class _64_MiniMumPathSum {

     public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        //fill first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        //fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        _64_MiniMumPathSum mimPathSum = new _64_MiniMumPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int rs = mimPathSum.minPathSum(grid);
        System.out.println(rs);
    }
}
