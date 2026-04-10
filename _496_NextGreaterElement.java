import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_NextGreaterElement {

//   public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
//         Stack<Integer> stack = new Stack<>();
//         Map<Integer,Integer> map = new HashMap<>();

//         for (int i = nums2.length - 1; i >= 0; i--) {
//             if (stack.isEmpty()) {
//                 stack.push(nums2[i]);
//                 map.put(nums2[i], -1);
//             }else{
                 
//                 if (nums2[i] >= stack.peek()) {
//                     stack.push(nums2[i]);
//                     map.put(nums2[i], -1);
//                 }else{
//                    int val = stack.pop();
//                    stack.push(nums2[i]);
//                    map.put(nums2[i], val);
//                 }
//             }
//         }

//         for (int i = 0; i < nums1.length; i++) {
//            nums1[i] = map.get(nums1[i]);
//         }

//         return nums1;
//     }

public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Pop all smaller elements
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // Now stack top is next greater, if exists
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            // Push current element
            stack.push(nums2[i]);
        }

        // Prepare result for nums1
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {2,1,5,3,4};

        int[] rs = nextGreaterElement(num1, num2);

        for (int i : rs) {
           System.out.print(i + " "); 
        }
    }
}
