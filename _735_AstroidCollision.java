import java.util.Stack;

public class _735_AstroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (Integer asteroid : asteroids) {
            boolean destroyed  = false;

            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {

                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                }else if(Math.abs(st.peek()) == Math.abs(asteroid)){
                    st.pop();
                    destroyed  = true;
                    break;
                }else{
                    destroyed  = true;
                    break;
                }
                
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] res = new int[st.size()];

          for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;

    }

    public static void main(String[] args) {
        int[] astroids = {3,5,-6,2,-1,4};

        int[] res = asteroidCollision(astroids);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
