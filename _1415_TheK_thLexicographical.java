import java.util.ArrayList;
import java.util.List;

public class _1415_TheK_thLexicographical {

    public static String getHappyString(int n , int k){
        List<String> result = new ArrayList<>();
        backTrack(n, "", result);
        if (result.size() < k) {
            return "";
        }
        return result.get(k - 1);
    }

    static void backTrack(int n, String current, List<String> result){
        if(current.length() == n){
            result.add(current);
            return;
        }

        char[] chars = {'a','b','c'};

        for (char c : chars) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) continue;

            backTrack(n, current + c, result);
        }
    }

    public static void main(String[] args){
        System.out.println(getHappyString(3, 9));
    }
}
