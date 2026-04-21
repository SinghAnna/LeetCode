import java.util.HashMap;
import java.util.Map;

public class _2958_MaxSubArrayLenMostFeq {

     public static int maxSubarrayLength(int[] nums, int k) {

        int n = nums.length;
        int maxLen = 0;
        int left = 0;
     

        Map<Integer,Integer> feq = new HashMap<>();

        for (int right = 0; right < n; right++) {

           feq.put(nums[right], feq.getOrDefault(nums[right], 0) + 1);

           while (feq.get(nums[right]) > k) {
                feq.put(nums[left], feq.get(nums[left]) - 1);
                left++;
           }
            
           maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
        
    }

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,1,2,3,1,2};
        int ans = maxSubarrayLength(nums, 2);
        System.out.println(ans);
    }
}
