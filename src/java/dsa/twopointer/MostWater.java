package dsa.dividenconquer.java.dsa.twopointer;

public class MostWater {

    public static int maxArea(int[] height){
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;
        int tempArea = 0;
        while (leftIndex < rightIndex){
            tempArea = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxArea = Math.max(tempArea, maxArea);
            if(height[leftIndex] < height[rightIndex]){
                leftIndex++;
            }
            else {
                rightIndex--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        height = new int[]{1,1};
        System.out.println(maxArea(height));
    }
}
