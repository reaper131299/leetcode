package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String args[]){
        PartitionLabels p = new PartitionLabels();
        p.partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        int idx =0;
        List<Integer> list = new ArrayList<>();

        int[] lastIndexes = new int[26];

        for(int i = 0; i<s.length(); i++){
            lastIndexes[s.charAt(i)-'a'] = i;
        }

        while (idx<s.length()){
            int lastIdx = lastIndexes[s.charAt(idx)-'a'];

            for(int i = idx+1; i <lastIdx; i++){
                lastIdx = Math.max(lastIndexes[s.charAt(i)-'a'], lastIdx);
            }

            list.add(lastIdx-idx+1);
            idx = lastIdx+1;
        }

        return list;
    }
}
