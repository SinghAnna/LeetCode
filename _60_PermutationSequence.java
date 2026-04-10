import java.util.*;

public class _60_PermutationSequence {

    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        for(int i = 1; i < n; i++){
            fact *= i;
        }

        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }

        k--; 
        StringBuilder ans = new StringBuilder();

        while(true){

            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);

            if(numbers.size() == 0) break;

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        _60_PermutationSequence p = new _60_PermutationSequence();
        System.out.println(p.getPermutation(3,3));

    }
}