import java.util.Stack;

public class _1544_MakeTheStringGreat {

    // public String makeGood(String s) {
    //     Stack<Character> st = new Stack<>();

    //     StringBuilder ans = new StringBuilder();

    //     for (Character ch : s.toCharArray()) {

    //         if (!st.isEmpty()) {
    //             char top = st.peek();

    //             if (Math.abs(top - ch) == 32) {
    //                 st.pop();
    //                 continue;
    //             }
    //         }

    //         st.push(ch);
    //     }

    //     for (Character character : st) {
    //         ans.append(character);
    //     }

    //     return ans.toString();

    // }

    public String makeGood(String s){

        char[] stack = new char[s.length()];

        int size = 0;
      for (char c : s.toCharArray()) {
        if (size == 0 || (stack[size - 1] ^ c) != 32) {
            stack[size++] = c;
        }else{
            size--;
        }
      }
        
      return new String(stack , 0, size);
    }


    public static void main(String[] args) {
        _1544_MakeTheStringGreat makeTheStringGreat = new _1544_MakeTheStringGreat();
        String s = "leEeetcode";

        String res = makeTheStringGreat.makeGood(s);

        System.out.println(res);
    }
}
