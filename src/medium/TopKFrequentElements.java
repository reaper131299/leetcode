package medium;

import java.util.*;

//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int i : nums){
//            map.putIfAbsent(i,0);
//            map.put(i, map.get(i)+1);
//        }
//        for(int i = 0; i<k; i++){
//            int maxCount = 0;
//            int maxnum = 0;
//            for(Map.Entry<Integer, Integer> e : map.entrySet()){
//                if(e.getValue()>maxCount) {
//                    maxCount = e.getValue();
//                    maxnum = e.getKey();
//                }
//            }
//            result.add(maxnum);
//            map.remove(maxnum);
//        }
//        return result.stream().mapToInt(i -> i).toArray();
//    }
//}

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        t.topKFrequent(new int[]{1}, 1);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            if(n<min) min = n;
            if(n>max) max = n;
        }

        int maxFreq = 0;
        int[] freq = new int[max-min+1];

        for(int n : nums){
            freq[n-min]++;
            if(freq[n-min]>maxFreq){
                maxFreq=freq[n-min];
            }
        }

        List<Integer>[] finalArr = new ArrayList[maxFreq+1];

        for(int n = 0; n<freq.length; n++){
            if (freq[n] > 0) {
                if(finalArr[freq[n]]==null){
                    finalArr[freq[n]] = new ArrayList<>();
                }
                finalArr[freq[n]].add(n+min);
            }
        }

        int[] result = new int[k];
        int i= 0;
        int start = finalArr.length-1;
        while(i<k && start >= 0){
            if(finalArr[start] != null){
                for(int num : finalArr[start]){
                    if(i<k){
                        result[i] = num;
                        i++;
                    } else {
                        return result;
                    }
                }
            }
            start--;
        }
        return result;
    }
}