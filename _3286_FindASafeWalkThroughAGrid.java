import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _3286_FindASafeWalkThroughAGrid {

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        Deque<int[]> dq = new ArrayDeque<>();

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid.get(0).get(0);

        dq.offerFirst(new int[] { 0, 0 });

        int[][] dirs = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 }
        };

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int cost = grid.get(nr).get(nc);
                    int newDist = dist[r][c] + cost;

                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;

                        if (cost == 0) {
                            dq.offerFirst(new int[] { nr, nc });
                        } else {
                            dq.offerLast(new int[] { nr, nc });
                        }
                    }
                }

               
            }
            
        }

         return dist[m - 1][n - 1] < health;

        
    }

    public static void main(String[] args) {

        List<List<Integer>> grid = List.of(
                List.of(0, 1, 0, 0, 0),
                List.of(0, 1, 0, 1, 0),
                List.of(0, 0, 0, 1, 0));

        boolean res = findSafeWalk(grid, 1);

        System.out.println(res);

    }
}
