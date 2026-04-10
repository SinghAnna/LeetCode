public class _416_PartitionEqualSubSetSum {

      public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        

        return dp[target];
    }
    public static void main(String[] args) {

        _416_PartitionEqualSubSetSum ptSum = new _416_PartitionEqualSubSetSum();

        int[] nums = {1,5,11,5};

        boolean ans = ptSum.canPartition(nums);

        System.out.println(ans);
        
    }
}
