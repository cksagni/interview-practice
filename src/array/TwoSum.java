package array;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        List<Integer> integerList;
        for (int i = 0; i < nums.length; i++){
            if (numMap.containsKey(nums[i])) {
                integerList = numMap.get(nums[i]);
                integerList.add(i);
                numMap.put(nums[i], integerList);
            }
            else {
                integerList = new ArrayList<>();
                integerList.add(i);
                numMap.put(nums[i], integerList);
            }
        }
        for (Map.Entry<Integer, List<Integer>> keyValue: numMap.entrySet()){

            int n1 = keyValue.getKey();
            int n2 = target - n1;
            if (numMap.containsKey(n2)){
                integerList = numMap.get(n1);
                if (n1 == n2 && integerList.size() > 1)
                    return new int[]{integerList.get(0), integerList.get(1)};
                else
                    return new int[]{integerList.getFirst(), numMap.get(n2).getFirst()};
            }
        }
        return new int[]{};
    }

    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (indexMap.containsKey(target - nums[i]))
                return new int[] {i, indexMap.get(target - nums[i])};
            indexMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 9, 4, 5};
        int target = 7;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        System.out.println(Arrays.toString(new TwoSum().twoSumOptimized(nums, target)));

        nums = new int[]{2,7,11,15};
        target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        System.out.println(Arrays.toString(new TwoSum().twoSumOptimized(nums, target)));

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        System.out.println(Arrays.toString(new TwoSum().twoSumOptimized(nums, target)));


        nums = new int[]{3,3};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        System.out.println(Arrays.toString(new TwoSum().twoSumOptimized(nums, target)));
    }
}
