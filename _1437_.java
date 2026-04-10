public class _1437_ {

public static boolean kLengthApart(int[] nums, int k) {
    int lastOne = -1;  
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            if (lastOne != -1 && (i - lastOne - 1) < k) {
                return false;
            }
            lastOne = i;
        }
    }
    return true;
}


    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 0, 1, 0, 0, 1 };

        System.out.println(kLengthApart(arr, 2));

    }
}
