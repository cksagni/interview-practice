package twopointer;

import java.util.Arrays;

public class TwoSumII {
    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number. Let these two numbers
    be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer
    array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.
     */

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
