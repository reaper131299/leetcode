package medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-2, 0, 1, 1, 2});

    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<String> aleadyCotnains = new HashSet<>();
//        Set<List<Integer>> res = new HashSet<>();

    /// /        for(int n : nums){
    /// /            x.add(n);
    /// /        }
//
//        Set<Integer> seeBefore1 = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!seeBefore1.contains(nums[i])) {
//                int target = -nums[i];
//                Set<Integer> set = new HashSet<>();
//                for (int j = 0; j < nums.length; j++) {
//                    if (i == j) continue;
//                    if (!set.contains(target - nums[j])) {
//                        set.add(nums[j]);
//                    } else {
//                        List<Integer> list = Arrays.asList(target - nums[j], nums[j], nums[i]);
//                        Collections.sort(list);
//                        res.add(list);
//                    }
//                }
//            }
//            seeBefore1.add(nums[i]);
//        }
//        return new ArrayList<>(res);
//    }
//
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        Set<Integer> seenBefore = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return res;
    }
}
