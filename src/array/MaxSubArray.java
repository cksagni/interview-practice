package array;

public class MaxSubArray {

    public int maxSubArrayBrute(int[] nums){
        int maxSum = nums[0];
        for(int i = 0; i < nums.length - 1;  i++){
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public int maxSubArrayOptimal(int[] nums){
        int maxSum = nums[0];
        int sum = maxSum;
        for (int i = 1; i < nums.length;  i++){
            sum = sum + nums[i];
            if (sum < nums[i])
                sum = nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArrayBrute(nums));
        System.out.println(new MaxSubArray().maxSubArrayOptimal(nums));

        nums = new int[]{1};
        System.out.println(new MaxSubArray().maxSubArrayBrute(nums));
        System.out.println(new MaxSubArray().maxSubArrayOptimal(nums));

        nums = new int[]{5,4,-1,7,8};
        System.out.println(new MaxSubArray().maxSubArrayBrute(nums));
        System.out.println(new MaxSubArray().maxSubArrayOptimal(nums));

    }
}
