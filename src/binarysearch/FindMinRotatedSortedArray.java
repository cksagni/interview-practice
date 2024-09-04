package binarysearch;

public class FindMinRotatedSortedArray {
    /*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
    [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    You must write an algorithm that runs in O(log n) time.
     */

    public static int findMin(int[] nums){
        int leftIndex = 0, rightIndex = nums.length - 1, middleIndex;
        while (leftIndex < rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] > nums[rightIndex]){
                leftIndex = middleIndex + 1;
            }else{
                rightIndex = middleIndex;
            }
        }
        return nums[leftIndex];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2})==1);
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2})==0);
        System.out.println(findMin(new int[]{11,13,15,17})==11);
        System.out.println(findMin(new int[]{3,4,5,6,1})==1);
        System.out.println(findMin(new int[]{3,4})==3);
        System.out.println(findMin(new int[]{4,3})==3);
    }
}
