package stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces,
square brackets are well-formed, etc. Furthermore, you may assume that the original data does
not contain any digits and that digits are only for those repeat numbers, k.
For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.
 */
public class DecodeString {

    public static String decodeString(String s){
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                stack.push(String.valueOf(s.charAt(i)));

            }
            else{
                String output = "";
                while (!Objects.equals(stack.peek(), "[")){
                    output = stack.pop() + output;
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().matches("\\d+")){
                    num.insert(0, stack.pop());
                }
                if (!num.isEmpty()){
                    int n = Integer.parseInt(num.toString());
                    String res = output;
                    output = IntStream.range(0, n)
                            .mapToObj(k -> res)
                            .collect(Collectors.joining());
                }
                stack.add(output);
            }
        }
        while (!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(decodeString("3[a]2[bc]"), "aaabcbc"));
        System.out.println(Objects.equals(decodeString("3[a2[c]]"), "accaccacc"));
        System.out.println(Objects.equals(decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef"));
        System.out.println(Objects.equals(decodeString("10[a]"), "aaaaaaaaaa"));

    }
}
