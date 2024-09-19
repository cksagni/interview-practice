package twopointer;

import java.util.Arrays;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target){
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        int[] indexes = null;
        int temp = 0;

        while(indexes == null && leftIndex < rightIndex){
            temp = numbers[leftIndex] + numbers[rightIndex];
            if (temp == target){
                indexes = new int[]{leftIndex+1, rightIndex+1};
            }
            else if (temp < target){
                leftIndex++;
            }
            else{
                rightIndex--;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));

        numbers = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));

        numbers = new int[]{-1, 0};
        System.out.println(Arrays.toString(twoSum(numbers, -1)));

        numbers = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));

    }


}
