public class _518_CoinChange11 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

       
            for (int coin : coins) {
               for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
               }
            }
        

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] amount = {1,2,5};

        _518_CoinChange11 coinCount = new _518_CoinChange11();
        int ans = coinCount.change(5, amount);
        System.out.println(ans);
    }
}
