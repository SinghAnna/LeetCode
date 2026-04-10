import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

    public static List<List<Integer>> combine(int n ,int k){
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    static void  backTrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result){
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = start; i <= n; i++) {
            current.add(i);
            backTrack(n, k, i+1, current, result);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args){
        List<List<Integer>> rs = new ArrayList<>();
        rs = combine(4, 2);
        System.out.println(rs);
    }
}
