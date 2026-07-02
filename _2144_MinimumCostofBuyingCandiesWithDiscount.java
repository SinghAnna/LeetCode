import java.util.Arrays;
import java.util.Collections;

public class _2144_MinimumCostofBuyingCandiesWithDiscount {

      public static int minimumCost(int[] cost) {
        int minCost = 0;

        Arrays.sort(cost);
        reverse(cost);

        
        int j = 0;
        for (int i : cost) {
            if(j == 2){
                j = 0;
                continue;
            }

            minCost += i;
            j++;

        }


        return minCost;
        
    }

    static void reverse(int[] arr) {
    int l = 0, r = arr.length - 1;

    while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
    }
}
    public static void main(String[] args) {
        int[] cost = {1,2,3};
        int result = minimumCost(cost);

        System.out.println(result);
    }
}
