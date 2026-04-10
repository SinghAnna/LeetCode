public class _137_SingleNumber_II {
    public static int Inner_137_SingleNumber_II(int[] arr) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for(int num : arr){

                if (((num >> i) & 1) == 1) {
                    System.out.println(((num >> i) & 1) );
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result = result | (1<< i);
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,3};
        int rs = Inner_137_SingleNumber_II(nums);
        System.out.println(rs);
    }
}
