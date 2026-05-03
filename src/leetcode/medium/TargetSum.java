package leetcode.medium;

import java.util.Arrays;

public class TargetSum {

    int count = 0;
    int[][] dp;
    int sum;

    public static void main(String args[]){
        TargetSum t = new TargetSum();
        t.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        this.sum = sum;

        dp = new int[nums.length+1][sum*2+1];

        for(int[] n : dp){
            Arrays.fill(n, -1);
        }

        return findTargetSumWays(nums, target, 0, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int total, int idx) {
        if(total == target && idx ==  nums.length) {
            dp[idx][sum+total] = 1;
            return 1;
        } else if(idx >=  nums.length){
            return 0;
        }

        if(dp[idx][sum+total] != -1) return dp[idx][sum+total];

        int addingCurrElement = findTargetSumWays(nums, target, total + nums[idx], idx+1);
        int negatingCUrrElement = findTargetSumWays(nums, target, total-nums[idx], idx+1);

        dp[idx][sum+total] = addingCurrElement + negatingCUrrElement;

        return dp[idx][sum+total];
    }
}
