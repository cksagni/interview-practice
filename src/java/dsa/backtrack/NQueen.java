package dsa.backtrack;

import java.util.HashSet;
import java.util.Set;

public class NQueen {
    int size;
    public int totalNQueens(int n){
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public int backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals){

        if (row == size) return 1;
        int solution = 0;
        for (int col = 0; col < size; col++){
            int currDiagonal = col - row;
            int currAntiDiag = col + row;
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiag)) continue;
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiag);
            solution += backtrack(row + 1, cols, diagonals, antiDiagonals);
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiag);
        }
        return solution;

    }

    public static void main(String[] args) {
        System.out.println(new NQueen().totalNQueens(4));
        System.out.println(new NQueen().totalNQueens(1));

    }
}
