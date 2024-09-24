package dsa.dividenconquer.java.dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<int[]> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        int top[] = stack.isEmpty() ? new int[]{val, val} : stack.getLast();
        int min_val = top[1];
        min_val = Math.min(min_val, val);
        this.stack.add(new int[]{val, min_val});
    }

    public void pop() {
        this.stack.removeLast();
    }

    public int top() {
        return this.stack.getLast()[0];
    }

    public int getMin() {
        return this.stack.getLast()[1];
    }
}
