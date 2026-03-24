package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public static void main(String args[]){
        Permutations p = new Permutations();
        p.permute(new int[]{1,2,3});
    }

//    public List<List<Integer>> permute(int[] nums) {
//        this.nums = nums;
//        return permuteUtil(0);
//    }
//
//    public List<List<Integer>> permuteUtil(int pos){
//        if(pos == nums.length){
//            List<List<Integer>> arr = new ArrayList<>();
//            arr.add(new ArrayList<>());
//            return arr;
//        }
//
//        List<List<Integer>> permutations = permuteUtil(pos+1);
//
//        List<List<Integer>> ret = new ArrayList<>();
//        for(List<Integer> l : permutations){
//            for(int i = 0; i<=l.size();i++){
//                List<Integer> lCopy = new ArrayList<>(l);
//                lCopy.add(i, nums[pos]);
//                ret.add(lCopy);
//            }
//        }
//        return ret;
//    }


    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        used = new boolean[nums.length];

        List<Integer> init = new ArrayList<>();
        permuteUtil(init);

        return res;
    }

    public void permuteUtil(List<Integer> init){
        if(init.size() == nums.length){
            res.add(new ArrayList<>(init));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            init.add(nums[i]);
            permuteUtil(init);

            init.removeLast();
            used[i] = false;
        }
    }
}
