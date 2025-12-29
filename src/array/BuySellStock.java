package array;

public class BuySellStock {
    public int maxProfitBruteForce(int[] prices){
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfitOptimal(int[] prices){
        int maxProfit = 0;
        int cheapest = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < cheapest){
                cheapest = prices[i];
            } else if (prices[i] - cheapest > maxProfit) {
                maxProfit = prices[i] - cheapest;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(new BuySellStock().maxProfitBruteForce(prices));
        System.out.println(new BuySellStock().maxProfitOptimal(prices));

        prices = new int[] {7, 6, 4, 3, 1};
        System.out.println(new BuySellStock().maxProfitBruteForce(prices));
        System.out.println(new BuySellStock().maxProfitOptimal(prices));

    }
}
