package dsa.array;

public class BuySellStock2 {
    public int maxProfit(int[] prices){
        int maxProfit = 0, i = 1;
        while (i < prices.length){
        while (i < prices.length && prices[i - 1] >= prices[i]) i++;
        int valley = prices[i - 1];
        while (i < prices.length && prices[i - 1] <= prices[i]) i++;
        int peak = prices[i - 1];
        maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public int maxProfitS(int[] prices){
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i - 1] < prices[i]) maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println(new BuySellStock2().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new BuySellStock2().maxProfitS(new int[]{7,1,5,3,6,4}));
        System.out.println();
        System.out.println(new BuySellStock2().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new BuySellStock2().maxProfitS(new int[]{1,2,3,4,5}));
    }
}
