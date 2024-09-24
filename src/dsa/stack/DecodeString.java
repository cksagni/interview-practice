package dsa.stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
