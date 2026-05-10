public class _1464_MaximumProductofTwoElementsInAnArray {

     public int maxProduct(int[] nums) {
        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        
       for (int num : nums) {

        if (num > first_max) {
            second_max = first_max;
            first_max = num;
        }else if(num > second_max){
            second_max = num;
        }

        
        
       }

        return (first_max - 1 ) * ( second_max - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,5};
        _1464_MaximumProductofTwoElementsInAnArray max = new _1464_MaximumProductofTwoElementsInAnArray();

        int res = max.maxProduct(nums);

        System.out.println(res);
    }
}
