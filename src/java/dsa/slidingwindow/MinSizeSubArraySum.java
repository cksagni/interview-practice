package dsa.dividenconquer.java.dsa.slidingwindow;

public class MinSizeSubArraySum {
    public static int minSubArrayLength(int target, int[] nums){
        int sum = 0;
        int minLength = nums.length+1;
        int leftIndex = 0;
        for (int index=0; index < nums.length; index++){
            sum += nums[index];
            while (sum >= target) {
                minLength = Math.min(minLength, index - leftIndex + 1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }
        return minLength > nums.length ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLength(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLength(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLength(7, new int[]{1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLength(8, new int[]{1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLength(11, new int[]{1,2,3,4,5}));
    }
}
