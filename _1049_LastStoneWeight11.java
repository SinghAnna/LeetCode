public class _1049_LastStoneWeight11 {

        public int lastStoneWeightII(int[] stones) {

            int totalSum = 0;

            for (int i = 0; i < stones.length; i++) {
                totalSum += stones[i];
            }

            int target = totalSum / 2;

            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

          for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = dp[i] || dp[i-stone];
            }
          }

          for(int j = target; j >= 0; j--){
            if (dp[j]) {
                return totalSum - 2 * j;
            }
          }
            
          return 0;
    }

    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};

        int ans = new  _1049_LastStoneWeight11().lastStoneWeightII(stones);

        System.out.println(ans);
    }
}
