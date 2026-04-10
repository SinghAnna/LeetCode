import java.util.Arrays;

public class _435_NonOverlappingIntervals {
    
    public static int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 0) return 0;
      
      
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);


       int count = 1;  // first interval selected
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (current[1] <= intervals[i][0]) {
                count++;
                current = intervals[i];
            }
        }


        return intervals.length - count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int val = eraseOverlapIntervals(intervals);
        System.out.println("Final val : "+ val);
    }
}
