package leetcode.hard;

import java.util.Arrays;

public class BurstBalloons {

    int[][] dp;

    public static void main(String args[]) {
        BurstBalloons b = new BurstBalloons();
        b.maxCoins(new int[]{1,5});
    }

    public int maxCoins(int[] nums) {
        dp = new int[nums.length+2][nums.length+2];
        int[] numsCopy = new int[nums.length+2];

        for (int i = 0; i< nums.length; i++){
            numsCopy[i+1] = nums[i];
        }
        numsCopy[0] = 1;
        numsCopy[nums.length+1] = 1;

        for(int[] n : dp){
            Arrays.fill(n, -1);
        }

        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[nums.length+1], 1);

        for(int i = 0 ; i<=nums.length+1; i++){
            dp[i][0] = 1;
            dp[i][nums.length+1] = 1;
        }

        int max =  maxCoinsUtil(numsCopy, 1, nums.length);
        return max;
    }

    private int maxCoinsUtil(int[] nums, int l, int r){
        if(r<l) return 0;

        if(dp[l][r] != -1) return dp[l][r];
        int max = 0;

        for(int i = l; i<=r; i++){
            max = Math.max(max, nums[l-1]*nums[i]*nums[r+1] + maxCoinsUtil(nums, l, i-1) + maxCoinsUtil(nums, i+1, r));
        }

        dp[l][r] = max;

        return max;
    }
}



















