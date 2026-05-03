package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CoinChange {
    int[] minCoins;
    int maxAmount;

    public static void main( String args[]){
        CoinChange c = new CoinChange();
        c.coinChange(new int[]{2}, 3);
    }

//    public int coinChange(int[] coins, int amount) {
//        this.amount = amount;
//        minCoins = new Integer[amount+1];
//        int result = coinChangeUtil(coins, amount);
//        if(result>amount) return -1;
//        return minCoins[amount];
//    }
//
//    public Integer coinChangeUtil(int[] coins, int need) {
//        if(need == 0){
//            minCoins[need] = 0;
//            return 0;
//        }
//        if(need <0) return amount+1;
//
//        if(minCoins[need] !=null) return minCoins[need];
//
//        int minCount = amount+1;
//        for (int coin : coins) {
//            int tempMinCoins = 1 + coinChangeUtil(coins, need - coin);
//            if (tempMinCoins < minCount) minCount = tempMinCoins;
//        }
//
//        minCoins[need] = minCount;
//
//        return minCount;
//    }

//    public int coinChange(int[] coins, int amount) {
//        int[] minCoins = new int[amount+1];
//        Arrays.fill(minCoins, amount+1);
//        minCoins[0] = 0;
//
//        for(int i = 0; i<minCoins.length; i++){
//            for (int coin : coins){
//                if(coin<=i){
//                    minCoins[i] = Math.min(minCoins[i], 1+ minCoins[i - coin]);
//                }
//            }
//        }
//        if(minCoins[amount]>amount){
//            return -1;
//        }
//        return minCoins[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        minCoins = new int[amount+1];
        Arrays.fill(minCoins, amount+1);
        minCoins[0]=0;
        coinChangeUtil(coins, amount);
        if(minCoins[amount] == amount+1) return -1;
        return minCoins[amount];
    }

    public void coinChangeUtil(int[] coins, int amount) {
        if(amount == 0) return;

        coinChangeUtil(coins, amount-1);

        for(int coin : coins) {
            if(coin<=amount) {
                minCoins[amount] = Math.min(1 + minCoins[amount - coin], minCoins[amount]);
            }
        }
    }
}
