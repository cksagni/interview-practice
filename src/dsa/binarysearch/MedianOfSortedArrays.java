package dsa.binarysearch;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int totalElements = nums1.length + nums2.length;
        double median1 = 0.0, median2 = 0.0;
        boolean oneElementMedian = totalElements % 2 == 1;
        int index = totalElements / 2;
        int firstPointer = 0, secondPointer = 0, counter = 0;
        while (counter <= index){
            median2 = median1;
            counter++;
            if (firstPointer < nums1.length && secondPointer < nums2.length){
                if (nums1[firstPointer] < nums2[secondPointer]){
                    median1 = nums1[firstPointer++];
                } else {
                    median1 = nums2[secondPointer++];
                }
            } else if (firstPointer < nums1.length){
                median1 = nums1[firstPointer++];
            } else {
                median1 = nums2[secondPointer++];
            }
        }
        if (oneElementMedian){
            return median1;
        } else {
            return (median1 + median2) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}) == 2.0);
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,4}) == 2.5);
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}) == 2.5);
        System.out.println(findMedianSortedArrays(new int[]{3,4}, new int[]{1,2}) == 2.5);
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{5}) == 3.0);
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{}) == 1.0);
        System.out.println(findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,4,4}) == 3.0);
        System.out.println(findMedianSortedArrays(new int[]{1,2,4}, new int[]{3}) == 2.5);
    }
}
