package leetcode.medium;

public class LongestCommonSubsequence {

    public static void main(String[] args){
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        l.longestCommonSubsequence("abcde", "ace");
    }

//    public int longestCommonSubsequence(String text1, String text2) {
//
//        char[] txt1 = text1.toCharArray();
//        char[] txt2 = text2.toCharArray();
//
//        int[][] dp = new int[text1.length()+1][text2.length()+1];
//
//        for(int row = 1; row<dp.length; row++){
//            for(int col = 1; col<dp[0].length; col++){
//                if(txt1[row-1] == txt2[col-1]){
//                    dp[row][col] = 1+ dp[row-1][col-1];
//                } else
//                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int row = 1; row<dp.length; row++){
            for(int col = 1; col<dp[0].length; col++){
                if(text1.charAt(row-1) == text2.charAt(col-1)){
                    dp[row][col] = 1+ dp[row-1][col-1];
                } else
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
