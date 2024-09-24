package dsa.array;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n){

        int r1 = m - 1;
        int r2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--){
            if (r2 < 0) break;
            if (r1 >= 0 && nums1[r1] > nums2[r2]){
                nums1[p] = nums1[r1];
                r1--;
            } else {
                nums1[p] = nums2[r2];
                r2--;
            }
        }


        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));

    }
}
