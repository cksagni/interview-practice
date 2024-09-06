package binarysearch;

public class SearchA2DMatrix {

    /*
    You are given an m x n integer matrix 'matrix' with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.
     */

    public static boolean searchMatrix(int[][] matrix, int target){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int leftIndex = 0, rightIndex = rows * columns - 1, middleIndex, rowIndex, columnIndex;
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            rowIndex = middleIndex / columns;
            columnIndex = middleIndex % columns;
            if(matrix[rowIndex][columnIndex] == target){
                return true;
            }
            else if (matrix[rowIndex][columnIndex] > target){
                rightIndex = middleIndex - 1;
            }
            else {
                leftIndex = middleIndex + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 60));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 1));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 7));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 78));
    }
}
