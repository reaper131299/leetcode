package leetcode;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks b = new BestTimeToBuyAndSellStocks();
        b.maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int right = 0;
        int leftMin = prices[left];
        int rightMax;
        int maxProfit = 0;
        while(right<n){
            if(prices[right]<leftMin){
                leftMin = prices[right];
            } else {
                rightMax = prices[right];
                maxProfit = Math.max(maxProfit, rightMax-leftMin);
            }
            right++;
        }
        return maxProfit;
    }
}
