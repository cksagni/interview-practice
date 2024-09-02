package twopointer;

public class Subsequence {
    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by
    deleting some (can be none) of the characters without disturbing the relative positions
    of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */

    public static boolean isSubsequence(String first, String second){
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < first.length() && secondIndex < second.length()){
            if (first.charAt(firstIndex) == second.charAt(secondIndex)){
                firstIndex++;
            }
            secondIndex++;
        }
        if (firstIndex == first.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
    }
}
