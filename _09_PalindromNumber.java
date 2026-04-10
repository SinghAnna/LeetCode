public class _09_PalindromNumber {

    static boolean isPalindromNumber(int x){

        if (x < 0) {
            return false;
        }

        int origanal = x;
        int reverse = 0;

        while (x != 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x =  x / 10;
        }

        if (origanal == reverse) {
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(isPalindromNumber(121));
    }
    
}
