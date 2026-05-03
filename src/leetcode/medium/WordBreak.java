package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    boolean[] arr;

    public static void main(String args[]){
        WordBreak w = new WordBreak();
        boolean exists = w.wordBreak("leetcode",
                Arrays.asList("leet","code"));
        int i = 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        arr = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return wordBreakUtil(s, set, 0);
    }

    public boolean wordBreakUtil(String s, Set<String> set, int idx){
        if(idx == s.length()) return true;

        if(arr[idx]) return !arr[idx];

        for(int i = idx; i<s.length(); i++ ){
            if(set.contains(s.substring(idx, i+1)) && wordBreakUtil(s, set, i+1)){
                return true;
            }
        }
        arr[idx] = true;
        return !arr[idx];
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> Dict =new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length()+1];
//        dp[0]=true;
//        for(int i=1;i<=s.length();i++){
//            for(int j=0;j<i;j++){
//                if(dp[j] && Dict.contains(s.substring(j,i))){
//                    dp[i]=true;
//                    break;
//                }
//            }
//        }
//        return dp[s.length()];
//
//
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] doesExist = new boolean[s.length()];
//        Set<String> set = new HashSet<>(wordDict);
//
//        for (int i = 0; i < s.length(); i++){
//            if(set.contains(s.substring(0, i+1) || boolean)
//        }
//
//    }
}
