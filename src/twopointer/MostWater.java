package twopointer;

public class MostWater {
    /*
    You are given an integer array height of length n. There are n vertical lines drawn
    such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container,
    such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */

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
