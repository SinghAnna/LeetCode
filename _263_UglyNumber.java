public class _263_UglyNumber {
     public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n/= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5; 
        }

        return n == 1;
    }
    public static void main(String[] args) {
        _263_UglyNumber uglyNumber = new _263_UglyNumber();

        System.out.println(uglyNumber.isUgly(6));
        System.out.println(uglyNumber.isUgly(14));
    }
}
