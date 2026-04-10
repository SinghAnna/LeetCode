// public class _2944_MinimumNumberCoin {

//     public static int minimumCoins(int[] prices) {
//         int n = prices.length;
//         int[] dp = new int[n + 1];

//         for (int i = n - 1; i >= 0; i--) {
//             dp[i] = Integer.MAX_VALUE;

//             // buy fruit i, next i fruits free
//             for (int j = i + 1; j <= Math.min(n, i + i + 1); j++) {
//                 dp[i] = Math.min(dp[i], prices[i] + dp[j]);
//             }
//         }
//         return dp[0];
//     }

//     public static void main(String[] args) {
//         int[] prices = {26,18,6,12,49,7,45,45};
//         System.out.println(minimumCoins(prices));
//     }
// }


public class _2944_MinimumNumberCoin {

    public static int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];

        // base case
        dp[n] = 0;

        // bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;

          
            for (int j = i + 1; j <= Math.min(n, 2 * (i + 1)); j++) {
                dp[i] = Math.min(dp[i], prices[i] + dp[j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] prices = {26, 18, 6, 12, 49, 7, 45, 45};
        System.out.println(minimumCoins(prices));
    }
}
