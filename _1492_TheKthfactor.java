public class _1492_TheKthfactor {

    public static int kthFactor(int n, int k){
       
        for (int i = 1; i <= n ; i++) {

            if (n % i == 0) {
                k--;
            }

             if (k == 0) {
                return i;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) {
        int rs = kthFactor(12, 3);
        System.out.println(rs);
    }
}