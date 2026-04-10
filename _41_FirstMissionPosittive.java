import java.util.HashSet;
import java.util.Set;

public class _41_FirstMissionPosittive {

    public static int findMissingPositive(int[] nums){
        int n = nums.length - 1;

        Set<Integer> numsList = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
        numsList.add(nums[i]);
    }

    for (int j = 1; j <= nums.length; j++) {
        if (!numsList.contains(j)) {
            return j;
        }
       
    }
     return n+1;
    }

    public static void main(String[] args){
        int[] nums = {3,4,-1,1};
        int rs = findMissingPositive(nums);
        System.out.println(rs);
    }
}
