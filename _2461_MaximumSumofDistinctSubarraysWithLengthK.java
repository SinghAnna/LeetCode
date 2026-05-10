import java.util.HashMap;

public class _2461_MaximumSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long winSum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            winSum += nums[right];

            if (right - left + 1 > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                winSum -= nums[left];
                left++;
            }

            if (right - left + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, winSum);
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

        _2461_MaximumSumofDistinctSubarraysWithLengthK maxSum = new _2461_MaximumSumofDistinctSubarraysWithLengthK();

        int[] nums = {1,5,4,2,9,9,9};

        long ans = maxSum.maximumSubarraySum(nums, 3);
        System.out.println(ans);
    }
}
