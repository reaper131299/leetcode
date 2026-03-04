package leetcode.easy;

public class MaxProfit {

    public static void main(String[] args) {
        maxProfit(new int[]{2,5,1,5});
    }

    public static int maxProfit(int[] prices) {
        int leastPrice = prices[0];
        int maxPrice = 0;
        int indexOfLeastPrice = 0;
        int indexOfMaxPrice = 0;
        int maxProfit= 0;
        for(int i = 0;i<prices.length;i++) {
            if(prices[i]<leastPrice) {
                leastPrice = prices[i];
                indexOfLeastPrice = i;
                maxPrice = prices[i];
                indexOfMaxPrice = i;
            } else if (prices[i]>=maxPrice) {
                maxPrice = prices[i];
                indexOfMaxPrice = i;
            }
            if(indexOfLeastPrice<=indexOfMaxPrice)
                maxProfit = Math.max(maxProfit, prices[indexOfMaxPrice]-prices[indexOfLeastPrice]);
        }

        return maxProfit;
    }
}
