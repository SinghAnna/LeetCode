public class _1415_theKThbestSolution {

    public String getHappyString(int n, int k){
        int total = 3 * (int)Math.pow(2, n - 1);
        if (k > total) return "";
        StringBuilder result = new StringBuilder();
        char prev = '#';

        for (int i = 0; i < n; i++) {
            char[] chars = {'a','b','c'};

            for (char c : chars) {
                if (c == prev) continue;

                int count = (int)Math.pow(2, n - 1 - i);
                if (k > count) {
                   k -= count;  
                }else{
                    result.append(c);
                    prev = c;
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        _1415_theKThbestSolution best = new _1415_theKThbestSolution();
        System.out.println(best.getHappyString(3, 9));
    }
}
