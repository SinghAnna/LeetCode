import java.util.Stack;

public class _1047_RemoveAllAdjasentDuplicatesinString {

    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek() == ch) {
                st.pop(); // remove pair
            } else {
                st.push(ch);
            }
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String str = "abbaca";

        String res = new _1047_RemoveAllAdjasentDuplicatesinString().removeDuplicates(str);

        System.out.println(res);
    }
}
