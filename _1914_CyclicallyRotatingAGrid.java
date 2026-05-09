import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1914_CyclicallyRotatingAGrid {


     public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int i = 0; i < layers; i++) {
            
            List<Integer> list = new ArrayList<>(m*n);

            int top = i;
            int left = i;
            int right = n - i -1;
            int bottom = m - i- 1;

            for (int j = left; j <= right; j++) {
                list.add(grid[top][j]);
            }
            for (int j = top +1; j <= bottom; j++) {
                list.add(grid[j][right]);
            }
            for (int j = right - 1; j >= left; j--) {
                list.add(grid[bottom][j]);
            }
            for (int j = bottom - 1; j > top; j--) {
                list.add(grid[j][left]);
            }

            int rotate = k % list.size();


            Collections.rotate(list, -rotate);

            int idx = 0;

            for (int j = left; j <= right; j++) {
               grid[top][j]  = list.get(idx++);
            }
            for (int j = top +1; j <= bottom; j++) {
                grid[j][right] = list.get(idx++);
            }
            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = list.get(idx++);
            }
            for (int j = bottom -1; j > top; j--) {
                grid[j][left] = list.get(idx++);
            }
        }


        return grid;
    }

    public static void main(String[] args) {

        _1914_CyclicallyRotatingAGrid rotatingAGrid = new _1914_CyclicallyRotatingAGrid();

        int[][] grid ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int[][] ans = rotatingAGrid.rotateGrid(grid, 2);

        for (int[] is : ans) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }
}
