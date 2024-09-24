package dsa.twopointer;

public class Subsequence {

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
