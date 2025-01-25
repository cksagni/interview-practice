package dsa.array;

public class JumpGame {
    public boolean canJump(int[] nums){

        int remainingJump = nums[0];
        for (int i = 1; i < nums.length; i++ ){
            remainingJump--;
            if (remainingJump < 0) return false;
            if (nums[i] > remainingJump) remainingJump = nums[i];
        }
        return true;
    }

    public int canJump2(int[] nums){
        int noOfJump = 1;
        int remainingJump = nums[0];
        int i = 0;
        while (i + remainingJump < nums.length-1){

            int maxPossible = nums[i+remainingJump];
            int maxIndex = i + remainingJump;
            int step = 0;
            for (int j = i + remainingJump; j > i; j--){
                if (nums[j] - step > maxPossible){
                    maxPossible = nums[j]-step;
                    maxIndex = j;
                }
                step++;
            }
            i = maxIndex;
            remainingJump = nums[maxIndex];
            noOfJump += 1;
        }
        return noOfJump;
    }

    public int canJump3(int[] nums){
        int noOfJumps = 0, curr = 0,farthestReach = 0;
        for (int i = 0; i < nums.length - 1; i++){
            farthestReach = Math.max(farthestReach, i + nums[i]);
            if (i == curr){
                noOfJumps++;
                curr = farthestReach;
            }
        }
        return noOfJumps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJump2(new int[]{2,3,1,1,4})==2);
        System.out.println(new JumpGame().canJump3(new int[]{2,3,1,1,4})==2);
        System.out.println();
        System.out.println(!new JumpGame().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJump2(new int[]{2,3,1,1,4})==2);
        System.out.println(new JumpGame().canJump3(new int[]{2,3,1,1,4})==2);
        System.out.println(new JumpGame().canJump2(new int[]{2,3,1})==1);
        System.out.println(new JumpGame().canJump3(new int[]{2,3,1})==1);
        System.out.println(new JumpGame().canJump2(new int[]{1,2,0,1})==2);
        System.out.println(new JumpGame().canJump3(new int[]{1,2,0,1})==2);
        System.out.println(new JumpGame().canJump2(new int[]{1,2,3})==2);
        System.out.println(new JumpGame().canJump3(new int[]{1,2,3})==2);

    }
}
