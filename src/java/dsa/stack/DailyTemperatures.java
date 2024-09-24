package dsa.dividenconquer.java.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures1(int[] temperatures){
        int[] waitTime = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++){
            for (int j = i + 1; j < temperatures.length; j++){
                if (temperatures[j] > temperatures[i]){
                    waitTime[i] = j - i;
                    break;
                }
            }
        }
        return waitTime;
    }

    public static int[] dailyTemperatures(int[] temperatures){
        int[] waitTime = new int[temperatures.length];
        int i = 1;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{temperatures[0], 0});
        while (i < temperatures.length){
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] tempIndex = stack.pop();
                waitTime[tempIndex[1]] = i - tempIndex[1];
            }
            stack.push(new int[]{temperatures[i], i});
            i++;
        }
        while (!stack.isEmpty()) {
            int[] tempIndex = stack.pop();
            waitTime[tempIndex[1]] = 0;
        }
        return waitTime;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.equals(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}), new int[]{1,1,4,2,1,1,0,0}));
        System.out.println(Arrays.equals(dailyTemperatures(new int[]{30,40,50,60}), new int[]{1,1,1,0}));
        System.out.println(Arrays.equals(dailyTemperatures(new int[]{30,60,90}), new int[]{1,1,0}));
    }
}
