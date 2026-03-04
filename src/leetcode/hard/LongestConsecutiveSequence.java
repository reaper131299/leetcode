package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }

//    public int longestConsecutive(int[] nums) {
//        if(nums.length == 0)
//            return 0;
//        Arrays.sort(nums);
//        int currMaxSeq = 0;
//        int runningMaxSeq = 1;
//        for(int i =0; i<nums.length-1;i++){
//            if(nums[i]==nums[i+1]) {
//                continue;
//            }
//            if(nums[i]+1==nums[i+1]){
//                runningMaxSeq++;
//            } else {
//                currMaxSeq = Math.max(currMaxSeq,runningMaxSeq);
//                runningMaxSeq = 1;
//            }
//        }
//        currMaxSeq = Math.max(currMaxSeq,runningMaxSeq);
//
//        return currMaxSeq;
//    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;

        for(int n : nums){
            if(n<min) min = n;
            if(n>max) max = n;
        }

        if(max-min<10000){
            boolean[] arr = new boolean[max-min+1];
            int range = arr.length;
            for(int n : nums){
                arr[n-min] = true;
            }

            int currMaxseq = 0;
            int runningMaxseq = 0;
            for (int i =0;i<=range;i++){
                if(arr[i])
                    runningMaxseq++;
                else {
                    currMaxseq = Math.max(currMaxseq, runningMaxseq);
                    runningMaxseq = 0;
                }
            }

            currMaxseq = Math.max(currMaxseq, runningMaxseq);
            res = currMaxseq;
        } else {
            Set<Integer> set = new HashSet<>();
            for(int n : nums){
                set.add(n);
            }

            int currMaxseq = 0;
            for(int n : set){
                if(!set.contains(n-1)){
                    int num = n;
                    int seq = 1;
                    while (set.contains(num+1)){
                        num++;
                        seq++;
                    }
                    currMaxseq = Math.max(currMaxseq, seq);
                }
            }
            res = currMaxseq;
        }
        return res;
    }
}
