public class _03_longestSubStringWithoutReapte {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
        //    System.out.println("h--- "+index[s.charAt(j)]);
        //    System.out.println(i);
            ans = Math.max(ans, j - i + 1);
          //  System.out.println(ans);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    } 

    public static void main(String[] args) {
        _03_longestSubStringWithoutReapte obj = new _03_longestSubStringWithoutReapte();
        String s = "abcb";
        System.out.println("Ans = "+obj.lengthOfLongestSubstring(s)); // Output: 3


        // int[] ch = new int[128];
    
        // System.out.println(ch['a']);
        // ch['a'] = 5;
        // System.out.println(ch['a']);

    }
}
