public class _747_LargeNoAtListTwiceOfOther {

    static int dominantIndex(int[] nums){

        if (nums.length == 0) {
            return -1;
        }

         int largeIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largeIdx]) {
                largeIdx = i;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j != largeIdx && nums[j] * 2 > nums[largeIdx]) {
                return -1;
            }
        }



        return largeIdx;
    }


    public static void main(String... args){

        int[] nums = {1,2,3,4};

        int rs = dominantIndex(nums);
        System.out.println(rs);
       

    }
}
