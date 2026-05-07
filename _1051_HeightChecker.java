import java.util.Arrays;

public class _1051_HeightChecker {
      public int heightChecker(int[] heights) {
        int count = 0;
        int[] expected = new int[heights.length];

        for (int i = 0; i < expected.length; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(expected);

        for (int i = 0; i < expected.length; i++) {
            if(expected[i] != heights[i]){
                count++;
            }
        }



        return count;
    }
    public static void main(String[] args) {
        
        _1051_HeightChecker heightChecker = new _1051_HeightChecker();

        int[] heights = {1,1,4,2,1,3};

        int ans  = heightChecker.heightChecker(heights);

        System.out.println(ans);
    }
}
