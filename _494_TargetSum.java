public class _494_TargetSum {

     public static int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (((target + totalSum) & 1) == 1 || target > totalSum) {
            return 0;
        }

        int option = (target + totalSum) >> 1;

        int[] dp = new int[option + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int i = option; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }


        return dp[option];
    }
    public static void main(String[] args) {
       int[] num = {1,1,1,1,1}; 
       int ans = findTargetSumWays(num, 3);
       System.out.println(ans);
    }
}
