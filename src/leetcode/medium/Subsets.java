package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    ArrayList<List<Integer>> res = new ArrayList<>();

    public static void main(String args[]){
        Subsets s = new Subsets();
        s.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {

        subsetUtil(new ArrayList<>(), nums, 0);

        return res;
    }

    private void subsetUtil(List<Integer> subset, int[] nums, int pos){
        if(pos >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subsetUtil(subset, nums, pos+1);
        subset.add(nums[pos]);
        subsetUtil(subset, nums, pos+1);
        subset.removeLast();
    }
}
