package stack;
/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.


 */
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
