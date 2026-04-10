import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {

    public static int[][] merge(int[][] intervals){

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            }else{
                ans.add(current);
                current = intervals[i];
            }
            
        }
            ans.add(current);

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //   int[][] intervals = {{4,7},{1,4}};
        int[][] ans = merge(intervals);
        
        for (int[] is : ans) {
            System.out.print(" ,");
           for (int is2 : is) {
            System.out.print(is2 + " ") ;
           }
        }
    }
}
