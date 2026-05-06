import java.util.ArrayList;
import java.util.List;

public class _1431_KidsWiththeGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        int threshold = max - extraCandies;

        for (int candy : candies) {
            result.add(candy >= threshold);
        }

        return result;
    }

    public static void main(String[] args) {

        _1431_KidsWiththeGreatestNumberOfCandies eCandies = new _1431_KidsWiththeGreatestNumberOfCandies();

        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;

        List<Boolean> list = eCandies.kidsWithCandies(candies, extraCandies);

        System.out.println(list);
    }
}