import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval){

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        //add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        //merge overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.max(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        

        //3 add remaning
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
       
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        
        int[][] rs  = insert(intervals, newInterval);

        for (int[] is : rs) {
            System.out.print(" ");
            for (int is2 : is) {
                System.out.print(is2+ " ");
            }
        }
    }
}
