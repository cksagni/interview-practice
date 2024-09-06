package binarysearch;

public class FindPeakElement {
    /*
    A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, find a peak element, and return its index.
    If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
    always considered to be strictly greater than a neighbor that is outside the array.

    You must write an algorithm that runs in O(log n) time.
     */
    public static int findPeakElement(int[] nums){
        int leftIndex = 0, rightIndex = nums.length - 1, middleIndex;
        if (nums.length == 1){
            return 0;
        }else if (nums[leftIndex] > nums[leftIndex + 1]){
            return leftIndex;
        } else if (nums[rightIndex] > nums[rightIndex - 1]){
            return rightIndex;
        }
        while (leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] > nums[middleIndex - 1] && nums[middleIndex] > nums[middleIndex + 1]){
                return middleIndex;
            } else if (nums[middleIndex + 1] > nums[middleIndex]){
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,7}));
        System.out.println(findPeakElement(new int[]{3,2,1,3,5}));
        System.out.println(findPeakElement(new int[]{3,2}));
        System.out.println(findPeakElement(new int[]{2,3}));
        System.out.println(findPeakElement(new int[]{3,4,3,2,1}));

    }
}
