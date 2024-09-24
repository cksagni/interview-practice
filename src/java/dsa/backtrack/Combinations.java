package dsa.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    int size;
    int comb;
    public List<List<Integer>> combine(int n, int k) {
        size = n;
        comb = k;
        backtrack(new ArrayList<>(), 1);
        return result;
    }
    
    public void backtrack(List<Integer> currentOutput, int next){
        if (currentOutput.size()==comb){
            result.add(new ArrayList<>(currentOutput));
            return;
        }
        for (int j = next ; j <= size; j++){
            currentOutput.add(j);
            backtrack(currentOutput, j + 1);
            currentOutput.removeLast();
        }
    }



    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,2));
        System.out.println(new Combinations().combine(1,1));
        System.out.println(new Combinations().combine(4,4));
        System.out.println(new Combinations().combine(4,3));
    }
}
