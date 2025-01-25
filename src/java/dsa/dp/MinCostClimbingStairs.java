package dsa.dp;

import java.util.Arrays;

public class MinCostClimbingStairs {
    int[] dp;
    public int minCostClimbingStairs(int[] cost){
        dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return minCost(cost, cost.length);
    }

    public int minCost(int[] cost, int start){
        if (start <= 1) return 0;
        if (dp[start] == -1){
            dp[start] = Math.min(cost[start - 1] + minCost(cost, start - 1),
                    cost[start - 2] + minCost(cost, start - 2));
        }
        return dp[start];
    }

    public int minCostClimbingStairsIter(int[] cost){
        int oneBelow = 0, twoBelow = 0;
        for (int i = 2; i <= cost.length; i++){
            int temp = Math.min(cost[i - 1] + oneBelow, cost[i - 2] + twoBelow);
            twoBelow = oneBelow;
            oneBelow = temp;
        }
        return oneBelow;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairsIter(new int[]{10,15,20}));
        System.out.println();
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairsIter(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
