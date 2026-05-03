package leetcode.medium;

import java.util.Arrays;

public class HouseRobber {

    int[] moneyRobbed;

    public static void main(String args[]){
        HouseRobber h = new HouseRobber();
        h.rob(new int[]{2,7,9,3,1});
    }

//    public int rob(int[] nums) {
//        moneyRobbed = new int[nums.length];
//        Arrays.fill(moneyRobbed, -1);
//        return robUtil(nums, 0);
//    }
//
//    public int robUtil(int[] nums, int index) {
//        if(index>=nums.length) return 0;
//
//        if(moneyRobbed[index]!=-1) return moneyRobbed[index];
//
//        int moneyWithCurrentHouse = nums[index] + robUtil(nums, index+2);
//        int moneyWithoutCurrentHouse = robUtil(nums, index+1);
//
//        moneyRobbed[index] =  Math.max(moneyWithCurrentHouse, moneyWithoutCurrentHouse);
//        return moneyRobbed[index];
//    }

//    public int rob(int[] nums) {
//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//        if(nums.length == 2) return Math.max(nums[0], nums[1]);
//
//        int[] moneyRobbed = new int[nums.length];
//        moneyRobbed[nums.length-1] = nums[nums.length-1];
//        moneyRobbed[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
//
//        for(int i = nums.length-3; i>=0; i--){
//            moneyRobbed[i] = Math.max(nums[i] + moneyRobbed[i+2], moneyRobbed[i+1]);
//        }
//
//        return moneyRobbed[0];
//    }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int moneyRobbed = 0;
        int x = nums[nums.length-1];
        int y = Math.max(nums[nums.length-2], nums[nums.length-1]);

        for(int i = nums.length-3; i>=0; i--){
            moneyRobbed = Math.max(nums[i] + x, y);
            x = y;
            y = moneyRobbed;
        }

        return moneyRobbed;
    }


}
