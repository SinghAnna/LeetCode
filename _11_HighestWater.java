public class _11_HighestWater {
    static int maxHeightWater(int[] height){
        int maxArea = 0;
        int left = 0 , right = height.length -1; 

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;

            int area = h * width;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            }
            else{
                right--;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        int maxWater = maxHeightWater(height);
        System.out.println(maxWater);
    }
}
