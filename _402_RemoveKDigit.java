import java.util.Stack;

public class _402_RemoveKDigit {

    public static String removeKdigits(String nums, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < nums.length(); i++) {
            char ch = nums.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // agar k abhi bhi bacha hai
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        for (char c : st) {
            res.append(c);
        }

        // remove leading zeros
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') {
            idx++;
        }

        String ans = res.substring(idx);

        return ans.length() == 0 ? "0" : ans;
    }

    public static void main(String[] args) {
        String val = "10200";
        System.out.println(removeKdigits(val, 1)); // 200
    }
}
