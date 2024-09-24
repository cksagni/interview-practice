package dsa.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SquareSum {

    public static int numSquares(int n){
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++ ){
            squares.add(i*i);
        }
        Set<Integer> queue = new HashSet<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()){
            level++;
            Set<Integer> nextQueue = new HashSet<>();
            for(Integer remainder: queue){
                for (Integer square: squares){
                    if (remainder.equals(square)){
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        nextQueue.add(remainder-square);
                    }
                }
            }
            queue = nextQueue;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13) == 2);
        System.out.println(numSquares(12) == 3);
        System.out.println(numSquares(15) == 4);
        System.out.println(numSquares(18) == 2);
    }
}
