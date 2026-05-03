package leetcode.medium;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    int[] profit;
    int[][] dp;

//    public int maxProfit(int[] prices) {
//        profit = new int[prices.length];
//        Arrays.fill(profit, -1);
//        return maxProfitUtil(prices, 0);
//    }

//    public int maxProfitUtil(int[] prices, int idx) {
//        if(idx >= prices.length) return 0;
//        if(profit[idx]!=-1) return profit[idx];
//        int maxProfit = 0;
//        for(int i = idx; i< prices.length; i++) {
//            if(profit[i]!=-1)  {
//                profit[idx] = Math.max(maxProfit, profit[i]);
//                return profit[idx];
//            }
//            for(int j = i+1; j<prices.length; j++){
//                if(prices[i]<prices[j]) {
//                    int p = prices[j]-prices[i] + maxProfitUtil(prices, j+2);
//                    maxProfit = Math.max(maxProfit, p);
//                }
//            }
//            while(prices[i]>=prices[i+1]) {
//                i++;
//            }
//        }
//        profit[idx] = maxProfit;
//        return maxProfit;
//    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        b.maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] n : dp){
            Arrays.fill(n, -1);
        }
        return maxProfitutil(prices, 0, 1);
    }

    public int maxProfitutil(int[] prices, int idx, int isBuy) {
        if (idx >= prices.length) return 0;

        if (dp[idx][isBuy] != -1) return dp[idx][isBuy];

        int max = 0;

        if (isBuy == 1) {
            max = Math.max(-prices[idx] + maxProfitutil(prices, idx + 1, 0), maxProfitutil(prices, idx + 1, 1));
            dp[idx][1] = max;
            return max;
        } else {
            max = Math.max((prices[idx] + maxProfitutil(prices, idx + 2, 0)), (maxProfitutil(prices, idx + 1, 1)));
            dp[idx][0] = max;
            return max;
        }
    }
}
