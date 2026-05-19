public class _3442_MaxDifference {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f % 2 == 1) {
                maxOdd = Math.max(maxOdd, f);
            } else if (f > 0) {
                minEven = Math.min(minEven, f);
            }
        }

        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0;
        }

        return maxOdd - minEven;

    }

    public static void main(String[] args) {

        _3442_MaxDifference maxDifference = new _3442_MaxDifference();
        String s = "abcabcab";
        int res = maxDifference.maxDifference(s);
        System.out.println(res);
    }
}
