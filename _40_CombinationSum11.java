import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSum11 {

    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int[] candidates,int target, int start, List<Integer> current, List<List<Integer>> result){

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
              if(i > start && candidates[i] == candidates[i-1]) continue;
            current.add(candidates[i]);
            backTrack(candidates, target-candidates[i], i+1, current, result);
            current.remove(current.size() - 1);
        }

    }


    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};

        _40_CombinationSum11 comSum2 = new _40_CombinationSum11();

        List<List<Integer>> rs = comSum2.combinationSum2(candidates, 8);

        System.out.println(rs);

    }
}
