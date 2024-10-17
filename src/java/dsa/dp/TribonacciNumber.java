package dsa.dp;

public class TribonacciNumber {
    public int tribonacciNumber(int n){
        int t0 = 0, t1 = 1, t2 = 1;
        if(n == 0) return t0;
        if(n == 1) return t1;
        if(n == 2) return t2;
        for (int i = 3; i <= n; i++){
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }
    public static void main(String[] args){
        System.out.println(new TribonacciNumber().tribonacciNumber(4));
        System.out.println(new TribonacciNumber().tribonacciNumber(25));
    }

}
