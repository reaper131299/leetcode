package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class EditDistance {

    public static void main(String args[]){
        EditDistance e = new EditDistance();
        e.minDistance("horse", "ros");
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        int seq = word1.length();
        for(int i = 0; i<word1.length(); i++){
            dp[i][word2.length()] = seq--;
        }

        seq = word2.length();
        for(int i = 0; i<word2.length(); i++){
            dp[word1.length()][i] = seq--;
        }

        for(int i = word1.length()-1; i>=0; i--) {
            for(int j = word2.length()-1; j>=0; j--) {
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1+ Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }

        return dp[0][0];
    }

}
