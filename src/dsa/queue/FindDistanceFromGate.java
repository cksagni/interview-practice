package dsa.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindDistanceFromGate {
    public static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public static final int GATE = 0;
    public static final int EMPTY = Integer.MAX_VALUE;

    public static int[][] findDistanceFromNearestGate(int[][] rooms){
        int m = rooms.length, row, col;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (row = 0; row < m; row++){
            for (col = 0; col < n; col++){
                if (rooms[row][col] == GATE){
                    queue.add(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            row = point[0];
            col = point[1];
            for (int[] direction : DIRECTIONS){
                int r = row + direction[0];
                int c = col + direction[1];
                if ( r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        int[][] output = new int[][]{
                {3,-1,0,1},
                {2,2,1,-1},
                {1,-1,2,-1},
                {0,-1,3,4}
        };
        System.out.println(Arrays.deepToString(findDistanceFromNearestGate(rooms)));
        System.out.println(Arrays.deepEquals(rooms, output));
    }
}
