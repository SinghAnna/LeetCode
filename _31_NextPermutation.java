public class _31_NextPermutation {


    static void nextPermutation(int[] nums){
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums,i,j);
        }

        reverse(nums,i+1,n-1);

        for (int p : nums) {
           System.out.print(p + " "); 
        }
    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    static void reverse(int[] nums, int i,int n){
        while (i < n) {
            swap(nums, i++, n--);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums); 
    }
}
