package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    int[] candidates;
    int target;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int n : candidates){
            arr.add(n);
        }

        this.candidates = arr.stream().mapToInt(i -> i).toArray();

        combinationSum2Util(0, 0, new ArrayList<>());

        return res;
    }

    public void combinationSum2Util(int pos, int sum, List<Integer> arr){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target || pos == candidates.length) return;

        arr.add(candidates[pos]);
        combinationSum2Util(pos+1, sum + candidates[pos], arr);
        arr.removeLast();

        while(pos+1<candidates.length && candidates[pos+1] == candidates[pos]){
            pos++;
        }
        combinationSum2Util(pos+1, sum, arr);
    }
}
