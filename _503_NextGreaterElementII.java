import java.util.Stack;

public class _503_NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // initialize ans with -1 (default when no next greater exists)
        for (int i = 0; i < n; i++) ans[i] = -1;

        // Loop 2 times (circular array logic)
        for (int i = 2*n - 1; i >= 0; i--) {

            int idx = i % n;

            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[idx] = stack.peek();
            }

            stack.push(nums[idx]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
