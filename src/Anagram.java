import java.util.HashMap;

public class Anagram {
    public static boolean isAnagram(String firstString, String secondString){
        if (firstString.length() != secondString.length()){
            return false;
        }
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (char c: firstString.toCharArray()){
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        for (char c: secondString.toCharArray()){
            if (characterCount.getOrDefault(c, 0) > 0){
                characterCount.put(c, characterCount.get(c) - 1);
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abcd", "bcda"));
        System.out.println(isAnagram("abcd", "bcdaa"));
        System.out.println(isAnagram("bat", "batsmen"));
        System.out.println(isAnagram("", "aa"));
    }
}
