package leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.prefs.PreferenceChangeListener;

public class PartitionEqualSubsetSum {

//    public boolean canPartition(int[] nums) {
//        return canPartition(nums, 0, 0, 0);
//    }
//
//    public boolean canPartition(int[] nums, int sum1, int sum2, int index) {
//        if(index == nums.length && sum1 == sum2) {
//            return true;
//        } else if(index == nums.length) {
//            return false;
//        }
//
//        return canPartition(nums, sum1+nums[index], sum2, index+1) || canPartition(nums, sum1, sum2+nums[index], index+1);
//    }

    public boolean canPartition(int[] nums) {
        int half = 0;
        int total = 0;

        if(nums.length == 1) return false;

        for(int n : nums){
            total+=n;
        }

        if(total%2 != 0) return false;
        half = total/2;

        boolean[] arr = new boolean[half+1];
        arr[0] = true;

        for(int n : nums){
            for(int i = half; i>=n; i--){
                arr[i] = arr[i] || arr[i-n];
            }
            if(arr[half]) return true;
        }
        return arr[half];
    }
}
