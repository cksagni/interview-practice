package dsa.dividenconquer.java.dsa.stack;

import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s){
        Map<Character, Character> openToClose = Map.of('[', ']', '{', '}', '(', ')');
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (openToClose.containsKey(c)){
                stack.push(c);
            }
            else if (openToClose.containsValue(c)){
                if (stack.isEmpty() || !openToClose.get(stack.pop()).equals(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("]"));
        System.out.println(isValid("(])"));
    }
}
