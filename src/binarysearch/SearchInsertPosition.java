package binarysearch;

public class SearchInsertPosition {
    /*
    Given a sorted array of distinct integers and a target value, return the index
    if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.
     */

    public static int searchInsert(int[] nums, int target){
        int leftIndex = 0, rightIndex = nums.length - 1, middleIndex;
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] == target){
                return middleIndex;
            } else if (nums[middleIndex] < target){
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3}, 2));
    }
}
