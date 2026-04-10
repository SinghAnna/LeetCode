public class _34_findFirstAndLastPosition {

      static int[] binarySearchRecursive(int[] arr, int start, int end, int target) {
        int[] result = {-1,-1};
        if (start > end)
            return  result;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target && result[0] == -1) {
            result[0] = mid;
           
        }
         if (arr[mid] == target && result[1] == -1 &&  result[0] != -1) {
            result[1] = mid;  
        }

        if (result[0] == result[1] && result[0] != -1) {
            return result;
        }
        

         if (arr[mid] < target) {
            return binarySearchRecursive(arr, mid + 1, end, target);
        } else {
            return binarySearchRecursive(arr, start, mid - 1, target);
        }

    }


     public static int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
      
        int n = nums.length;

        if (nums[0] == target && nums[1] == target) {
            result[0] = 0;
            result[1] = 1;
            return result ;
        }

        int i = 1;
        while (i < n && nums[i] <= target) {
            i = i * 2;
        }

        return binarySearchRecursive(nums, i/2,Math.min(i,n-1),target);
       
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};

        int[] resuly = searchRange(nums, 8);

        for (int i : resuly) {
            System.out.println(i);
        }

    }
}
