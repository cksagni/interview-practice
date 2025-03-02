package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static int[][] DIRECTIONS = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int colorToBeChanged = image[sr][sc];
        if (colorToBeChanged == color) return image;
        int m = image.length - 1;
        int n = image[0].length - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int[] dir: DIRECTIONS){
                int xTemp = x + dir[0];
                int yTemp = y + dir[1];
                if(xTemp < 0 || yTemp < 0 || xTemp > m || yTemp > n || image[xTemp][yTemp] != colorToBeChanged || image[xTemp][yTemp] == color ){
                    continue;
                }
                image[xTemp][yTemp] = color;
                queue.add(new int[]{xTemp, yTemp});
            }
        }
        return image;
    }

    public static int[][] floodFillR(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    public static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r - 1, c, color, newColor);
            }
            if (c >= 1) {
                dfs(image, r, c - 1, color, newColor);
            }
            if (r + 1 < image.length) {
                dfs(image, r + 1, c, color, newColor);
            }
            if (c + 1 < image[0].length) {
                dfs(image, r, c + 1, color, newColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));

        int[][] image1 = {
                {0,0,0},
                {0,0,0}
        };
        System.out.println(Arrays.deepToString(floodFill(image1, 0, 0, 0)));
    }
}
