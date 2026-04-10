
import java.util.HashSet;
import java.util.Set;



// Time O(nlogn)
// public class _128_LongestConsecutiveSequence {

//     public static int longestConsecutive(int[] nums) {
//         if (nums.length == 0)
//             return 0;

//         Arrays.sort(nums);

//         int curr = 1; // current sequence length
//         int max = 1; // max sequence length

//         for (int i = 1; i < nums.length; i++) {

//             if (nums[i] == nums[i - 1]) {
//                 continue; // duplicate ignore
//             }

//             if (nums[i] - nums[i - 1] == 1) {
//                 curr++;
//             } else {
//                 curr = 1;
//             }

//             max = Math.max(max, curr);
//         }

//         return max;
//     }

    //beat for interview time complexity O(n)

 public class _128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int n : nums) {
    set.add(n);
    }

    int longest = 0;

    for (int n : set) {

    // start of sequence
    if (!set.contains(n - 1)) {
    int curr = n;
    int count = 1;

    while (set.contains(curr + 1)) {
    curr++;
    count++;
    }

    longest = Math.max(longest, count);
    }
    }

    return longest;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums)); // ✅ 4
    }
}
