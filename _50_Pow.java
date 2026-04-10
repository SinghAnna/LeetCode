public class _50_Pow {

    public double myPow(double x, int n) {
        long N = n; // overflow handle
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    public static double power(double x, long n) {
        if (n == 0) return 1;

        double half = power(x, n / 2);

        if ((n & 1) == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10)); // 1024
    }
}
