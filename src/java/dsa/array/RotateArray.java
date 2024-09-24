package dsa.dividenconquer.java.dsa.array;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k){
        k = k % nums.length;
        int[] rotated = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        int left = nums.length - k - 1;
        int right = nums.length - 1;
        while (left >= 0){
            nums[right] = nums[left];
            right--;
            left--;
        }
        k--;
        while (k >= 0){
            nums[right] = rotated[k];
            right--;
            k--;
        }
    }

    public static void rotateConstantSpace(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length ; start++){
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                current = next;
                prev = temp;
                count++;

            }while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6,7};
        rotateConstantSpace(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
