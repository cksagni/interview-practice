package dsa.twopointer;

public class Palindrome {

    public static boolean isPalindrome(String s){
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex){
            while(leftIndex < s.length() && !Character.isLetterOrDigit(s.charAt(leftIndex))){
                leftIndex++;
            }
            while(rightIndex >= 0 && !Character.isLetterOrDigit(s.charAt(rightIndex))){
                rightIndex--;
            }
          if (leftIndex < s.length() && rightIndex >= 0 && Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))){
              return false;
            }
          leftIndex++;
          rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("malayalam"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("abcde"));
        System.out.println(isPalindrome("ssddss"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }
}
