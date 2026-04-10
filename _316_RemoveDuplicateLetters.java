import java.util.Stack;

public class _316_RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        // last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        // iterate over String
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // all ready in stack

            if (visited[ch - 'a']) {
                continue;
            }

            // pop larger leter if they appear later

            while (!st.isEmpty()
                    && st.peek() > ch
                    && lastIndex[st.peek() - 'a'] > i) {

                visited[st.pop() - 'a'] = false;
            }

            // push current character
            st.push(ch);
            visited[ch - 'a'] = true;

        }

        StringBuilder result = new StringBuilder();

        for (char c : st) {
            result.append(c);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String result = removeDuplicateLetters("cbacdcbc");
        System.out.println(result);
    }
}
