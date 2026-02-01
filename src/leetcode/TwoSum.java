package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberAndIndexMapping = new HashMap<>();
        for(int i= 0; i<nums.length;i++) {
            if(numberAndIndexMapping.containsKey(target-nums[i]))
                return new int[] {numberAndIndexMapping.get(target-nums[i]),i};
            numberAndIndexMapping.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
