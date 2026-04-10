public class _233_NumberOfDigitOne {

    public static int countDigitOne(int n) {

        int count = 0;
        int factor = 1;
        int low = 0;

        while (n > 0) {
            int current = n % 10;
            int higher = n / 10;

            if (current == 0) {
                count += higher * factor;
            } 
            else if (current == 1) {
                count += higher * factor + (low + 1);
            } 
            else {
                count += (higher + 1) * factor;
            }

            low = low + current * factor;
            factor *= 10;
            n = higher;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13)); // Output: 6
    }
}
