package dsa.array;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums){
        int left = 1;
        int ptr = 1;
        int lastElementCount = 1;
        while (ptr < nums.length){
            if (nums[ptr] == nums[ptr-1]){
                lastElementCount++;
                if (lastElementCount > 2){
                    ptr++;
                    continue;
                }
            } else{
                lastElementCount = 1;
            }
            nums[left] = nums[ptr];
            left++;
            ptr++;
        }
        return Arrays.copyOfRange(nums, 0, left);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,3,3};

        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
