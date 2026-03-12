package leetcode.medium;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CombinationSum {
    int[] candidates;
    int target;
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String args[]){
        CombinationSum c = new CombinationSum();
        c.combinationSum(new int[]{2,3,6,7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        combinationSumUtil(new ArrayList<>(), 0, 0);

        return res;
    }

    //there is no need to explicitly add next element to the sum. as it will be automatically added if we skip the cuurent element
    //e.g.:- if we add 2 and 2 and in the 3rd iteration we skip 2, then in next iteration 3 will be added.
    //sp there is no specific need to add 3 in 3rd iteration.
    public void combinationSumUtil(ArrayList<Integer> arr, int pos, int sum){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        } else if(pos == candidates.length || sum>target) return;

        //add same number
        arr.add(candidates[pos]);
        combinationSumUtil(arr, pos, sum+candidates[pos]);
        arr.removeLast();

        combinationSumUtil(arr, pos+1, sum);
    }
}
