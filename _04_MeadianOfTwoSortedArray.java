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

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if (((n1 + n2) & 1) == 1) {
                 return Math.max(l1, l2);
                }else{
                    return( Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }


            if (l1 > r2) {
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }

        }

        return 0;
    }

    // best approch binary search O(log(m+n))

    public static void main(String[] args) {
        int[] num1 = { 1, 2 };
        int[] num2 = { 3, 4 };

        _04_MeadianOfTwoSortedArray meadian = new _04_MeadianOfTwoSortedArray();

        double ans = meadian.findMedianSortedArrays2(num1, num2);

        System.out.println(ans);
    }
}
