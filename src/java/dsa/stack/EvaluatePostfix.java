package dsa.dividenconquer.java.dsa.stack;

import java.util.*;
import java.util.function.BiFunction;

public class EvaluatePostfix {


    public static final Map<
            String,
            BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
                    "+", (a, b) -> a + b ,
                    "-", (a, b) -> a - b,
                    "*", (a, b) -> a * b,
                    "/", (a, b) -> a / b
    );

    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        int first, second, result;
        for (String token: tokens){
            if (OPERATIONS.containsKey(token)){
                second = stack.pop();
                first = stack.pop();
                BiFunction<Integer, Integer, Integer> operator = OPERATIONS.get(
                        token
                );
                result = operator.apply(first, second);
                stack.push(result);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(evalRPN(new String[]{"10"}));
    }
}
