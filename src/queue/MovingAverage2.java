package queue;

import java.util.Arrays;

public class MovingAverage2 {

    int[] stream;
    int index;
    int streamCount;
    int size;
    int total;

    public MovingAverage2(int size) {
        stream = new int[size];
        this.size = size;
    }

    public double next(int val) {
        total = total + val;
        if (streamCount < this.size) {
            streamCount++;
            stream[index] = val;
        }
        else{
            total -= stream[index];
            stream[index] = val;
        }
        index = (index + 1) % this.size;
        return (double) total / streamCount;
    }



    public static void main(String[] args) {
        MovingAverage2 avg = new MovingAverage2(5);
        System.out.println(avg.next(12009) == 12009.00000);
        System.out.println(avg.next(1965) == 6987.00000);
        System.out.println(avg.next(-940) == 4344.666666666667);
        System.out.println(avg.next(-8516) == 1129.50000);
        System.out.println(avg.next(-16446) == -2385.60000);
        System.out.println(avg.next(7870) == -3213.40000);
        System.out.println(avg.next(25545) == 1502.60000);
        System.out.println(avg.next(-21028) == -2515.00000);
        System.out.println(avg.next(18430) == 2874.20000);
        System.out.println(avg.next(-23464) == 1470.60000);

        avg = new MovingAverage2(3);
        System.out.println(avg.next(1) == 1.00000);
        System.out.println(avg.next(10) == 5.50000);
        System.out.println(avg.next(3)==4.666666666666667);
        System.out.println(avg.next(5) == 6.00000);
    }
}
