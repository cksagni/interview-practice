package stack;

import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Example 1:
    Input: s = "()"
    Output: true
     */

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
