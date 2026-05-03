package leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeII {

    int[][] dp;
    int[] coins;

    public static void main(String args[]){
        CoinChangeII c = new CoinChangeII();
        c.change(5, new int[]{1,2,5});
    }


//    public int change(int target, int[] candidates) {
//        dp = new int[target+1][candidates.length];
//        coins = candidates;
//        for(int[] n: dp){
//            Arrays.fill(n, -1);
//        }
//        return changeUtil(target, 0);
//    }
//
//    public int changeUtil(int target, int idx) {
//        if(idx>=coins.length || target < 0) return 0;
//        if(target == 0) return 1;
//
//        if(dp[target][idx] != -1) return dp[target][idx];
//
//        int ways = changeUtil(target-coins[idx], idx) + changeUtil(target, idx+1);
//
//        dp[target][idx] = ways;
//
//        return ways;
//    }


//    public int change(int target, int[] candidates) {
//        int[][] dp = new int[candidates.length+1][target+1];
//        for(int i = 0 ; i<= candidates.length; i++){
//            dp[i][0] = 1;
//        }
//
//        for(int row = 1; row<=candidates.length; row++){
//            for(int col = candidates[row-1]; col <=target; col++){
//                dp[row][col] = dp[row-1][col];
//                if(col - candidates[row-1]>=0){
//                    dp[row][col] = dp[row][col] + dp[row][col - candidates[row-1]];
//                }
//            }
//        }
//
//        return dp[candidates.length][target];
//    }

    public int change(int target, int[] candidates) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int candidate : candidates) {
            for (int t = candidate; t <= target; t++) {
                dp[t] = dp[t] + dp[t - candidate];
            }
        }

        return dp[target];
    }
}
