import java.util.LinkedList;
import java.util.Queue;

public class _994_rottingOrandes {

       public int orangesRotting(int[][] grid) {
        

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                for (int[] d : dir) {

                   int newRow = row + d[0];
                   int newCol = col + d[1];
                   
                   if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    
                    grid[newRow][newCol] = 2;
                    fresh--;
                    q.offer(new int[]{newRow,newCol});
                   }
                }
            }

            minutes++;
        }


        if (fresh > 0) {
            return -1;
        }else{
            return minutes;
        }
    }

    public static void main(String[] args) {

        _994_rottingOrandes rottingOrandes = new _994_rottingOrandes();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        int minutes = rottingOrandes.orangesRotting(grid);

        System.out.println(minutes);
    }
}
