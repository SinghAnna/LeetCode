public class _96_UniqueBinarySearchTree {

    public static int numTrees(int n){
        int[] dp  = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                dp[i] += dp[root - 1] * dp[i - root];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int ans = numTrees(3);
        System.out.println(ans);
    }
}
