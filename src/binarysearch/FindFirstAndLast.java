package binarysearch;

import java.util.Arrays;

public class FindFirstAndLast {

    public static int binarySearch(int[] nums, int target, boolean isSearchingFirstOccurrence){
        int leftIndex = 0, rightIndex = nums.length - 1, index = -1, middleIndex;

        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                index = middleIndex;
                if (isSearchingFirstOccurrence) {
                    rightIndex = middleIndex - 1;
                }else {
                    leftIndex = middleIndex + 1;
                }
            }
        }
        return index;
    }
    public static int[] searchRange(int[] nums, int target){
        int rangeStartIndex = binarySearch(nums, target, true);
        int rangeEndIndex = binarySearch(nums, target, false);
        return new int[]{rangeStartIndex, rangeEndIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}));
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 8, 8, 10}, 7), new int[]{1, 1}));
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1}));
        System.out.println(Arrays.equals(searchRange(new int[]{}, 0), new int[]{-1, -1}));
        System.out.println(Arrays.equals(searchRange(new int[]{1}, 0), new int[]{-1, -1}));
        System.out.println(Arrays.equals(searchRange(new int[]{1}, 1), new int[]{0, 0}));
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5), new int[]{0, 0}));
    }
}
