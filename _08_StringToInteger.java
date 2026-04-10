public class _08_StringToInteger {

    static int myAtoi(String s) {
        int len = s.length();
        int i = 0;
        int sign = 1;
        long result = 0;

        // 1. Skip leading spaces
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits
        while (i < len && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // 4. Overflow check
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * result);
    }

    public static void main(String... args) {
        int rs = myAtoi("  45875ahgv");
        System.out.println(rs); // 45875
    }
}
