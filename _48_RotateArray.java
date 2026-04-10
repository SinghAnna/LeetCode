public class _48_RotateArray {

    public static void rotateArray(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
       for(int i = 0; i < n; i++){
            for(int j = 0; j < n /2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
       }
    }

    public static void main(String[] args) {
        int[][] arr = { 
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9} 
        };

        System.out.println("Original Matrix:");
        for(int[] row : arr){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        rotateArray(arr);
        System.out.println("Rotated Matrix:");
        for(int[] row : arr){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
    }
}
}
