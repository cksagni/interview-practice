package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelfBrute(int[] nums) {
        int product;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            product = 1;
            for (int j = 0; j < nums.length; j++){
                if (j != i)
                    product = product * nums[j];
            }
            output[i] = product;
        }
        return output;
    }

    public int[] productExceptSelfOptimal(int[] nums) {
        ArrayList<int[]> intermediate = new ArrayList<>();
        int prefix = 1, suffix = 1;
        for (int i = 0; i < nums.length; i++){
            int[] tuple = new int[2];
            tuple[1] = 1;
            tuple[0] = 1;
            if ( i != 0)
                tuple[0] = prefix * nums[i - 1];
            prefix = tuple[0];
            intermediate.add(tuple);
        }
        for (int i = nums.length - 1; i >= 0; i--){
            int[] tuple = intermediate.get(i);
            if ( i != nums.length - 1)
                tuple[1] = suffix * nums[i + 1];
            suffix = tuple[1];
            intermediate.set(i, tuple);
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < intermediate.size(); i++){
            int [] tuple = intermediate.get(i);
            output[i] = tuple[0] * tuple[1];
        }
        return output;
    }

    public int[] productExceptSelfOptimalConstantSpace(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for (int i = 1; i < output.length; i++){
            output[i] = nums[i - 1] * output[i - 1];
        }
        int right_product = 1;
        for (int i = output.length - 2; i >= 0; i--){
            output[i] = right_product * nums[i + 1] * output[i];
            right_product = right_product * nums[i + 1];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfBrute(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfOptimal(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfOptimalConstantSpace(nums)));

        nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfBrute(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfOptimal(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfOptimalConstantSpace(nums)));



    }
}
