import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();

        backTrack(candidates, target,0, new ArrayList<>(), ans);

        return ans;
    }

    public void backTrack(int[] candidates, int target, int start, List<Integer> curent ,List<List<Integer>> result){

        if (target == 0) {
            result.add(new ArrayList<>(curent));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            curent.add(candidates[i]);
            backTrack(candidates, target-candidates[i],i, curent, result);
            curent.remove(curent.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};

        _39_CombinationSum comSumList = new _39_CombinationSum();
        List<List<Integer>> rs = comSumList.combinationSum(candidates, 7);

        System.out.println(rs);
    }
}
