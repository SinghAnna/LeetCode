public class _04_MeadianOfTwoSortedArray {

 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int l3 = l1 + l2;

        int[] num3 = new int[(l3 >> 1) + 1];

        int j = 0, k = 0;

        for (int i = 0; i <= l3 / 2; i++) {

            if (j < l1 && k < l2) {
                if (nums1[j] <= nums2[k]) {
                    num3[i] = nums1[j++];
                } else {
                    num3[i] = nums2[k++];
                }
            } else if (j < l1) {
                num3[i] = nums1[j++];
            } else {
                num3[i] = nums2[k++];
            }
        }

        if (l3 % 2 == 1) {
            return num3[l3 / 2];
        } else {
            return (num3[l3 / 2] + num3[l3 / 2 - 1]) / 2.0;
        }
    }


    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};  

        _04_MeadianOfTwoSortedArray meadian = new _04_MeadianOfTwoSortedArray();

        double ans = meadian.findMedianSortedArrays(num1, num2);

        System.out.println(ans);
    }
}
