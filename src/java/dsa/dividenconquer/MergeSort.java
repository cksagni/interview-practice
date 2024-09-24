package dsa.dividenconquer.java.dsa.dividenconquer;

import java.util.Arrays;

public class MergeSort {

    public static int[] sortArray(int[] nums){
        if (nums.length <= 1) return nums;
        int mid = nums.length/2;
        int[] leftList = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] rightList = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(leftList, rightList);
    }

    public static int[] merge(int[] leftList, int[] rightList){
        int[] returnList = new int[leftList.length + rightList.length];
        int left = 0, right = 0, ptr = 0;
        while(left < leftList.length && right < rightList.length){
            if (leftList[left] <= rightList[right]){
                returnList[ptr] = leftList[left];
                left++;
            } else{
                returnList[ptr] = rightList[right];
                right++;
            }
            ptr++;
        }
        while(left < leftList.length){
            returnList[ptr] = leftList[left];
            left++;
            ptr++;
        }
        while (right < rightList.length){
            returnList[ptr] = rightList[right];
            right++;
            ptr++;
        }
        return returnList;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,6,1,9,2,6,7,8,9,1,2};
        System.out.println(Arrays.toString(sortArray(input)));
    }
}
