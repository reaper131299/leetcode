package leetcode.medium;

public class JumpGame {

    boolean[] dp;

    public boolean canJump(int[] nums) {
        int target = nums.length-1;

        for(int i = nums.length-2; i>=0; i--){
            if(i+nums[i]>=target) {
                target = i;
            }

        }

        if(target!=0) {
            return false;
        }

        return true;
    }

    // public boolean canJumpUtil(int[] nums, int idx) {
    //     if(idx == nums.length - 1) {
    //         dp[idx] = true;
    //         return true;
    //     }

    //     else if(idx >= nums.length) return false;

    //     if(dp[idx] != null) return dp[idx];

    //     for(int i = nums[idx]; i >= 1; i--) {
    //         if(canJumpUtil(nums, idx+i)) {
    //             dp[idx] = true;
    //             return true;
    //         }
    //     }

    //     dp[idx] = false;
    //     return false;
    // }
}
