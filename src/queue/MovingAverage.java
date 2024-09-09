package queue;

public class MovingAverage {

    int[] data;
    int size;
    int count;
    int total;

    public MovingAverage(int size) {
        this.size = size;
        this.data = new int[size];
    }

    public double next(int val) {
        int index = this.count % this.size;
        this.total += val;
        this.count++;
        if (count > this.size){
            this.total -= this.data[(index + this.size)%this.size];
            this.data[index] = val;
            return (double) this.total / (double) this.size;
        } else{
            this.data[index] = val;
            return (double) this.total / (double) this.count;
        }

    }

    public static void main(String[] args) {
        MovingAverage avg = new MovingAverage(5);
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
    }
}