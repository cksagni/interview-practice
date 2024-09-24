package dsa.dividenconquer.java.dsa.stack;

public class TargetSum {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target){
        calculate(nums, 0, 0, target);
        return count;
    }

    public void calculate(int[] nums, int start, int sum, int target){
        if (start == nums.length){
            if (sum == target) count++;
            return;
        }
        calculate(nums, start + 1, sum - nums[start], target);
        calculate(nums, start + 1, sum + nums[start], target);

    }


    public static void main(String[] args) {
        TargetSum sum = new TargetSum();
        System.out.println(sum.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

}
