package dsa.binarysearch;

public class FindMinRotatedSortedArray {

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
