package leetcode.medium;

import java.util.Arrays;

public class JumpGameII {

    public static void main(String args[]){
        JumpGameII j = new JumpGameII();
        j.jump(new int[]{2,3,1,1,4});
    }


    public int jump(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length-1){
            int maxJump = 0;
            for(int i = left; i<=right; i++){
                maxJump = Math.max(maxJump, i+nums[i]);
            }
            left = right+1;
            right = maxJump;
            res++;
        }
        return res;
    }
}
