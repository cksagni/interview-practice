package dsa.stack;

import java.util.Stack;

public class BasicCalculator {
        public int calculate(String s){
            Stack<Integer> stack = new Stack<>();
            int sign = 1;
            int result = 0;
            int num = 0;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (Character.isDigit(c)){
                    num = num * 10 + c - '0';
                } else if (c == '+') {
                    result += num * sign;
                    sign = 1;
                    num = 0;
                } else if (c == '-') {
                    result += num * sign;
                    sign = -1;
                    num = 0;
                } else if (c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (c == ')') {
                    result += sign * num;
                    result *= stack.pop();
                    result += stack.pop();
                    num = 0;
                }
            }
            return result + num * sign;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate(" 1 + 1 ")==2);
        System.out.println(new BasicCalculator().calculate("-2+ 1")==-1);
        System.out.println(new BasicCalculator().calculate("1-(-2)")==3);
        System.out.println(new BasicCalculator().calculate(" 2 - 1 + 2 ")==3);
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)")==23);
        System.out.println(new BasicCalculator().calculate("(7)-(0)+(4)")==11);
    }
}
