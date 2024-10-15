package dsa.dp;

import java.util.Arrays;

public class HouseRobber {
    int[] dp;
    public int rob(int[] nums){
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return findAmount(nums, nums.length - 1);
    }

    private int findAmount(int[] nums, int i) {
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (dp[i] == -1) dp[i] = Math.max(findAmount(nums, i - 1), findAmount(nums, i - 2) + nums[i]);
        return dp[i];
    }

    public int robI(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1,2,3,1}));
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
        System.out.println(new HouseRobber().rob(new int[]{0,0,0,0}));

        System.out.println(new HouseRobber().robI(new int[]{1,2,3,1}));
        System.out.println(new HouseRobber().robI(new int[]{2,7,9,3,1}));
        System.out.println(new HouseRobber().robI(new int[]{0,0,0,0}));
    }
}
