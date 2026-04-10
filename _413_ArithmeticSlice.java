public class _413_ArithmeticSlice {


     public int numberOfArithmeticSlices(int[] nums) {
        int curr = 0;
        int ans = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                curr++;
                ans += curr;
            }else{
                curr = 0;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int ans = new _413_ArithmeticSlice().numberOfArithmeticSlices(nums);

        System.out.println(ans);
    }
}
