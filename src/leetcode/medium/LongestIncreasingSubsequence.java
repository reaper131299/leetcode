package leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count,1);
        int res = 1;

        for(int i = 1; i< nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    count[i] = Math.max(count[i], 1 + count[j]);
                    res = Math.max(res, count[i]);
                }
            }
        }

        return res;
    }
}
