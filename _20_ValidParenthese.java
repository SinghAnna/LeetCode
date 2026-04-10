public class _20_ValidParenthese {


    static boolean isValid(String str){

        int n = -1;

        char a[] = new char[str.length()];

        for (char c : str.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                a[++n] = c;
            }else{
                if (n >= 0 && (c == ')' && a[n] == '(')
                 || (c == '}' && a[n] == '{')
                  || (c == ']' && a[n] == '[')  ) {

                    n--;
      
                }else{
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String question = "{[()]}()";

        boolean rs = isValid(question);

        System.out.println("What it is Valid : " + rs);
    }
}
