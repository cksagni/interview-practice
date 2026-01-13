package array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray2 {
    public void rotateBrute(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int previousNumber = nums[0];
            for (int j = 0; j < nums.length; j++){
                int index = (j + 1) % nums.length;
                int temp = nums[index];
                nums[index] = previousNumber;
                previousNumber = temp;
            }
        }
    }

    public void rotateOptimal(int[] nums, int k){
        int count = 0;
        int current = 0;
        int prev = nums[current];
        int start = 0;
        while (count < nums.length){
            int next = (current + k)%nums.length;
            int temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;
            if (start == current) {
                current = (start + 1) % nums.length;
                start = current;
                prev = nums[current];
            }
        }
    }

    public void rotateByReverse(int[] nums, int k){
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        new RotateArray2().rotateBrute(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6,7};
        new RotateArray2().rotateOptimal(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6,7};
        new RotateArray2().rotateByReverse(nums, k);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{-1,-100,3,99};
        k = 2;
        new RotateArray2().rotateBrute(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1,-100,3,99};
        new RotateArray2().rotateOptimal(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1,-100,3,99};
        new RotateArray2().rotateByReverse(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        k = 0;
        new RotateArray2().rotateBrute(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1};
        new RotateArray2().rotateOptimal(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1};
        new RotateArray2().rotateByReverse(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
