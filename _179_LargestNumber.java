import java.util.Arrays;

public class _179_LargestNumber {

    public static String largestNumber(int[] nums) {
      
        // Step 1: Convert all integers to strings
        String[] sr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sr[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort using custom comparator
        Arrays.sort(sr, (a, b) -> (b + a).compareTo(a + b));
      
        // Step 3: Edge case - if highest number is "0"
        if (sr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Step 4: Build the result
        for (String s : sr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main() {
        int[] nums = { 3, 30, 34, 5, 9 };

        System.out.println(largestNumber(nums));

    }
}
