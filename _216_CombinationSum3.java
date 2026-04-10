import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result = new ArrayList<>();
        backTrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

        void backTrack(int k,int n ,int start,List<Integer> current, List<List<Integer>> result){

            if (n == 0 && current.size() == k) {
                result.add(new ArrayList<>(current));
                return;
            }

            if (n < 0 || current.size() > k) return;

            for (int i = start; i <= 9; i++) {
                current.add(i);
                backTrack(k, n - i, i+1, current, result);
                current.remove(current.size() - 1);
            }
        }

    public static void main(String[] args){
       
        List<List<Integer>> rs =  new _216_CombinationSum3().combinationSum3(3, 9);
        System.out.println(rs);
    }
}
