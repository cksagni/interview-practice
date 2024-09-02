package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class EvaluatePostfix {
    /*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that:
    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.
     */

    public static int evalRPN(String[] tokens){
        List<String> operators = List.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        int first, second, result;
        for (String token: tokens){
            if (operators.contains(token)){
                second = stack.pop();
                first = stack.pop();
                if (token.equals("+")){
                    result = first + second;
                }
                else if (token.equals("-")){
                    result = first - second;
                }
                else if(token.equals("*")){
                    result = first * second;
                }
                else {
                    result = (int) first / second;
                }
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
