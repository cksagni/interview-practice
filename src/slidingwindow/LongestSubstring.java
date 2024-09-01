package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /*
    Given a string s, find the length of the longest substring  without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
     */

    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> charWithLastIndex = new HashMap<>();
        int maxLength = 0, leftIndex = 0, rightIndex;
        for(rightIndex = 0; rightIndex < s.length(); rightIndex++){
            if(charWithLastIndex.containsKey(s.charAt(rightIndex))){
                leftIndex = Math.max(leftIndex, charWithLastIndex.get(s.charAt(rightIndex)) + 1);
            }
            charWithLastIndex.put(s.charAt(rightIndex), rightIndex);
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));

    }
}
