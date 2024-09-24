package dsa.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> output = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n){
        this.n = n;
        backtrack(0,0, new StringBuilder());
        return output;
    }

    public void backtrack(int open, int closed, StringBuilder str){
        if (str.length() == 2*n){
            output.add(str.toString());
            return;
        }
        if (open < n){
            str.append("(");
            backtrack(open + 1, closed, str);
            str.deleteCharAt(str.length()-1);
        }
        if (closed < open){
            str.append(")");
            backtrack(open, closed + 1, str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
