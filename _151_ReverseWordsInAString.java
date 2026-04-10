import java.util.Stack;

public class _151_ReverseWordsInAString {

    public static String reverseWords(String s){
        StringBuilder result = new StringBuilder();
        Stack<String> st = new Stack<>();

        for (String string : s.trim().split("\\s")) {
            st.push(string);
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
            result.append(" ");
        }
      
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String str = "  hello world  ";
        
        String res = reverseWords(str);

        System.out.println(res);
        
    }
}
