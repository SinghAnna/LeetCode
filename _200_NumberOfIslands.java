public class _200_NumberOfIslands {

      public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }


        return count;
    }

    void dfs(char grid[][] , int i, int j){


        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0  || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','1'},
            {'0','0','0','0','0'}};

            _200_NumberOfIslands numberOfIslands = new _200_NumberOfIslands();

            int ans = numberOfIslands.numIslands(grid);

            System.out.println(ans);
    }
}
