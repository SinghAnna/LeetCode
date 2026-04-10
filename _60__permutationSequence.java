public class _60__permutationSequence {

    int curr = 0;
    String ans = "";

    void helper(int s, char[] arr, int k){

        if(ans.length() != 0){
            return;
        }

        if(s == arr.length){
            curr++;

            if(curr == k){
                ans = new String(arr);
            }
            return;
        }

        for(int i = s ; i < arr.length ; i++){

            swap(arr, s, i);
            helper(s + 1, arr, k);
            swap(arr, s, i); // backtrack

        }
    }

    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    String getPermutation(int n , int k){

        String s = "";

        for(int i = 1 ; i <= n ; i++){
            s = s + i;
        }

        helper(0, s.toCharArray(), k);

        return ans;
    }

    public static void main(String[] args) {

        _60__permutationSequence obj = new _60__permutationSequence();

        System.out.println(obj.getPermutation(3,3));

    }
}