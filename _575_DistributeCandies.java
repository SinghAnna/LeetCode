import java.util.HashSet;
import java.util.Set;

public class _575_DistributeCandies {


     public int distributeCandies(int[] candyType) {

        int res = 0;
        

        Set<Integer> caSet = new HashSet<>();

        for (int candy : candyType) {
            caSet.add(candy);
        }


        res = Math.min(caSet.size(), candyType.length / 2);

        return res;
        
    }

    public static void main(String[] args) {

        _575_DistributeCandies candies = new _575_DistributeCandies();

        int[] candy = {1,1,2,2,3,3};

        int ans = candies.distributeCandies(candy);

        System.out.println(ans);
    }
}
