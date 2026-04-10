import java.util.HashMap;
import java.util.Map;

public class _01_TwoSum {
    static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remain = target - num;
            if (map.containsKey(remain)) {
                return new int[] { map.get(remain), i };
            }
            map.put(num, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum(nums, target);
        if (res.length == 2) {
            System.out.println("Indices: " + res[0] + ", " + res[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
