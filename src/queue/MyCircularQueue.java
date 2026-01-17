package queue;

import javax.print.DocFlavor;
import java.sql.SQLOutput;

class MyCircularQueue {
    int[] data;
    int head;
    int count;
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (this.isFull())
            return false;
        data[(head + count) % data.length] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty())
            return false;
        head = (head + 1) % data.length;
        count--;
        return true;
    }

    public int Front() {
        if (this.isEmpty())
            return -1;
        return data[head];
    }

    public int Rear() {
        if (this.isEmpty())
            return -1;
        return data[(head + count - 1) % data.length];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(10);
        boolean param_1 = obj.enQueue(3);
        obj.enQueue(5);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
//        System.out.println(param_3);
        int param_4 = obj.Rear();
//        System.out.println(param_4);
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
        System.out.println("param1: " + param_1 + ", param2:" + param_2 + ", param3: " + param_3 +
                ", param4:" + param_4 + ", param5: " + param_5 + ", param6:" + param_6);
    }
}