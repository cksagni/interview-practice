package array;

public class ContainerWithMostWater {

    public int maxAreaBrute(int[] height) {
        int area, maxArea = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = i + 1; j < height.length; j++){
                area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int maxAreaOptimal(int[] height){
        int area, maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            area = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = new ContainerWithMostWater().maxAreaBrute(heights);
        System.out.println(ans);
        assert ans == 49;

        ans = new ContainerWithMostWater().maxAreaOptimal(heights);
        System.out.println(ans);
        assert ans == 49;
        //----------------------------------------------------------------

        heights = new int[]{1, 1};
        ans = new ContainerWithMostWater().maxAreaBrute(heights);
        System.out.println(ans);
        assert ans == 1;

        ans = new ContainerWithMostWater().maxAreaOptimal(heights);
        System.out.println(ans);
        assert ans == 1;



    }
}
