import java.util.Stack;

public class _1544_MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for (Character ch : s.toCharArray()) {

            if (!st.isEmpty()) {
                char top = st.peek();

                if (Math.abs(top - ch) == 32) {
                    st.pop();
                    continue;
                }
            }

            st.push(ch);
        }

        for (Character character : st) {
            ans.append(character);
        }

        return ans.toString();

    }

    public static void main(String[] args) {
        _1544_MakeTheStringGreat makeTheStringGreat = new _1544_MakeTheStringGreat();
        String s = "leEeetcode";

        String res = makeTheStringGreat.makeGood(s);

        System.out.println(res);
    }
}
