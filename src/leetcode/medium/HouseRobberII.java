package leetcode.medium;

import java.util.Arrays;

public class HouseRobberII {

    public static void main(String args[]){
        HouseRobberII h = new HouseRobberII();
        h.rob(new int[]{1,2,3,1});
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] moneyRobbed = new int[nums.length-1];

        moneyRobbed[moneyRobbed.length-1] = nums[nums.length-1];
        moneyRobbed[moneyRobbed.length-2] = Math.max(nums[nums.length-1], nums[nums.length-2]);
        for(int i = nums.length-3; i>=1; i--){
            moneyRobbed[i-1] = Math.max(nums[i]+moneyRobbed[i+1], moneyRobbed[i]);
        }

        int moneyRobbedWithoutFirstHouse = moneyRobbed[0];
        Arrays.fill(moneyRobbed, 0);

        moneyRobbed[moneyRobbed.length-1] = nums[nums.length-2];
        moneyRobbed[moneyRobbed.length-2] = Math.max(nums[nums.length-2], nums[nums.length-3]);
        for(int i = nums.length-4; i>=0; i--){
            moneyRobbed[i] = Math.max(nums[i]+moneyRobbed[i+2], moneyRobbed[i+1]);
        }
        int moneyRobbedWithFirstHouse = moneyRobbed[0];

        return Math.max(moneyRobbedWithFirstHouse, moneyRobbedWithoutFirstHouse);
    }
}
