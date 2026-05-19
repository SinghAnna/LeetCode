import java.util.ArrayDeque;
import java.util.Deque;


public class _239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        int size = n - k + 1;

        int[] ans = new int[size];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                ans[idx++] = nums[deque.getFirst()];
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        _239_SlidingWindowMaximum maxSlideWindow = new _239_SlidingWindowMaximum();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int[] res = maxSlideWindow.maxSlidingWindow(nums, 3);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
