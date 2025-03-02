package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoOfIslands {
    public static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] { 0,  1},
            new int[] { -1,  0},
            new int[] { 0,  -1}
    );

    public static int numIsIslands(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int numRows = grid.length;
        int numCol = grid[0].length;
        int numOfIslands = 0;
        for(int row = 0; row < numRows; row++){
            for (int col = 0; col < numCol; col++) {
                if (grid[row][col] == '1'){
                    numOfIslands++;
                    grid[row][col] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, col});
                    while(!queue.isEmpty()){
                        int[] point = queue.poll();
                        int r = point[0];
                        int c = point[1];
                        for (int[] direction : DIRECTIONS){
                            int tempR = r + direction[0];
                            int tempC = c + direction[1];
                            if ( tempR < 0 || tempC < 0 || tempR >= numRows || tempC >= numCol || grid[tempR][tempC] == '0'){
                                continue;
                            }
                            queue.add(new int[]{tempR, tempC});
                            grid[tempR][tempC] = '0';
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','1'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','1','1','1'}
        };
        System.out.println(numIsIslands(grid));


        grid = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        System.out.println(numIsIslands(grid));
    }
}
