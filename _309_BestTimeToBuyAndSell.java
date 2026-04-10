public class _309_BestTimeToBuyAndSell {

    static int maxProfit(int[] prices) {
      //base case 
        if (prices.length == 0) return 0;

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        int[] prices = {4,1,5,2,6};
        System.out.println(maxProfit(prices)); // Output: 3
    }
}
