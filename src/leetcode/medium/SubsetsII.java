package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        subsetIIUtil(0, new ArrayList<>());
        return res;
    }

    public void subsetIIUtil(int pos, ArrayList<Integer> arr){
        if(pos == nums.length ){
            res.add(new ArrayList<>(arr));
            return;
        }

        //with adding duplicate number once.
        arr.add(nums[pos]);
        subsetIIUtil(pos+1, arr);
        arr.removeLast();

        //with skipping duplicate number
        while(pos+1< nums.length && nums[pos] == nums[pos+1]) {
            pos++;
        }

        subsetIIUtil(pos+1, arr);
    }
}
