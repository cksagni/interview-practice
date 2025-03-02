package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static int[][] updateMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] DIRECTIONS = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for(int j =  0; j < n; j++){
                if (mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] index = queue.poll();
            int x = index[0];
            int y = index[1];
            int step = mat[x][y];
            for (int[] dir : DIRECTIONS){
                int tx = x + dir[0];
                int ty = y + dir[1];
                if (tx < 0 || ty < 0 || tx > m - 1 || ty > n - 1 || seen[tx][ty]){
                    continue;
                }
                seen[tx][ty] = true;
                mat[tx][ty] = step + 1;
                queue.add(new int[]{tx,ty});
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] image = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(Arrays.deepToString(updateMatrix(image)));

        int[][] image1 = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(image1)));
    }
}
