package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
     */

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int total;
        int leftIndex;
        int rightIndex;
        for(int firstIndex = 0; firstIndex < nums.length; firstIndex++){
            if (firstIndex >0 && nums[firstIndex] == nums[firstIndex-1]){
                continue;
            }
            leftIndex = firstIndex + 1;
            rightIndex = nums.length - 1;
            while (leftIndex < rightIndex){
                total = nums[firstIndex] + nums[leftIndex] + nums[rightIndex];
                if( total > 0){
                    rightIndex--;
                }
                else if(total < 0){
                    leftIndex++;
                }
                else {
                    result.add(new ArrayList<>(Arrays.asList(nums[firstIndex], nums[leftIndex],nums[rightIndex])));
                    leftIndex++;
                    rightIndex--;
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]){
                        leftIndex++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4, -4, 8};
        System.out.println(threeSum(nums));

        nums = new int[]{0,1,1};
        System.out.println(threeSum(nums));

        nums = new int[]{0,0,0};
        System.out.println(threeSum(nums));

        nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(nums));

        nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> expectedOutput = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(-4,0,4)), new ArrayList<>(Arrays.asList(-4,1,3)),
                new ArrayList<>(Arrays.asList(-3,-1,4)), new ArrayList<>(Arrays.asList(-3,0,3)),
                new ArrayList<>(Arrays.asList(-3,1,2)),new ArrayList<>(Arrays.asList(-2,-1,3)),
                new ArrayList<>(Arrays.asList(-2,0,2)), new ArrayList<>(Arrays.asList(-1,-1,2)),
                new ArrayList<>(Arrays.asList(-1,0,1))
            )
        );
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
        System.out.println(expectedOutput);
        System.out.println(result.equals(expectedOutput));

    }
}
