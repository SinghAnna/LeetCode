public class _1004_MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k){
        int left = 0;
        int zero = 0;
        int maxOnes = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zero++;
            }

            while (zero > k) {
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes,right - left + 1);
        }

        return maxOnes;
    }

    public static void main(String[] args) {

        _1004_MaxConsecutiveOnesIII loConsecutiveOnesIII = new _1004_MaxConsecutiveOnesIII();

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};

        int ans = loConsecutiveOnesIII.longestOnes(nums, 3);

        System.out.println(ans);
    }
}
