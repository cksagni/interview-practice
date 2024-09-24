package dsa.dividenconquer.java.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
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
