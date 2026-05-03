package leetcode.hard;

public class DistinctSubsequences {

    int[][] dp;

    public static void main(String args[]) {
        DistinctSubsequences d = new DistinctSubsequences();
        d.numDistinct("rabb", "rab");
    }

//    public int numDistinct(String s, String t) {
//        dp = new int[s.length()][t.length()];
//
//        for (int[] n : dp) {
//            Arrays.fill(n, -1);
//        }
//
//        return numDistinctUtil(s, t, 0, 0);
//    }
//
//    public int numDistinctUtil(String s, String t, int idx1, int idx2) {
//        if (idx2 == t.length()) {
//            return 1;
//        } else if (idx1 == s.length()) {
//            return 0;
//        }
//
//        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
//
//        int tempCount = 0;
//
//        if(s.charAt(idx1) == t.charAt(idx2)){
//            int take = numDistinctUtil(s, t, idx1+1, idx2+1);
//            int skip = numDistinctUtil(s, t, idx1+1, idx2);
//            tempCount = take+skip;
//        } else {
//            tempCount = numDistinctUtil(s, t, idx1+1, idx2);
//        }
//
//        dp[idx1][idx2] = tempCount;
//
//        return tempCount;
//    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (int) dp[m][n];
    }
}
