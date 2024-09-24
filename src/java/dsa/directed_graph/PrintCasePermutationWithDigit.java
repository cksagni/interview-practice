package dsa.dividenconquer.java.dsa.directed_graph;

import java.util.ArrayList;
import java.util.List;

public class PrintCasePermutationWithDigit {

    public static List<String> permute(String input){
        List<String> output = new ArrayList<>();
        String op = "";
        solve(input, op, output);
        return output;
    }

    public static void solve(String ip, String op, List<String> output){

        if (ip.isEmpty()){
            output.add(op);
        } else{
            if (Character.isDigit(ip.charAt(0))){
                solve(ip.substring(1), op + ip.charAt(0), output);
            } else {
                solve(ip.substring(1), op + Character.toLowerCase(ip.charAt(0)), output);
                solve(ip.substring(1), op + Character.toUpperCase(ip.charAt(0)), output);
            }
        }

    }

    public static void main(String[] args){
        String ip ="a1b1";
        System.out.println(permute(ip));
    }
}
