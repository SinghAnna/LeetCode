import java.util.LinkedList;
import java.util.Queue;

public class _542_01Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0 , - 1 } };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : direction) {

                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];

                if(r >= 0 && c >= 0 && r < m && c < n) {
                    if (mat[r][c] > mat[cur[0]][cur[1]] + 1) {
                        mat[r][c] = mat[cur[0]][cur[1]] + 1;
                        queue.offer(new int[] { r, c });
                    }
                }
            }

        }

        return mat;
    }

    public static void main(String[] args) {

        _542_01Matrix distanceMatrix = new _542_01Matrix();

        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        int[][] result = distanceMatrix.updateMatrix(matrix);

        for (int[] is : result) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }
}
