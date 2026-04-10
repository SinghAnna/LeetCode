import java.util.LinkedList;
import java.util.Queue;

public class _1293_ShortestPathInGrid {

    public static int shortestPath(int[][] grid,int k){

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][][] visited = new boolean[m][n][k+1];

        q.offer(new int[]{0,0,k,0});

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        //  left,right,bottom, up
        while (!q.isEmpty()) {
            
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int rem  = curr[2];
            int step = curr[3];

            if (r == m-1 && c == n-1) {
                return step;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int newRem = rem - grid[nr][nc];

                    if (newRem >= 0 && !visited[nr][nc][newRem]) {
                        visited[nr][nc][newRem] = true;
                        q.offer(new int[]{nr,nc,newRem,step+1});
                    }
                }
            }
        }



        return -1;
    }

    public static void main(String[] args){
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};

        int step = shortestPath(grid, 1);
        System.out.println("Step = "+ step);
    }
}