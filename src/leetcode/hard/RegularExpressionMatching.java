package leetcode.hard;

public class RegularExpressionMatching {

    Boolean[][] dp;

    public static void main(String args[]){
        RegularExpressionMatching r = new RegularExpressionMatching();
        r.isMatch("aa", "a");
    }


    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return isMatchUtil(s, p, 0, 0);
    }

    // when we get j+1 as star we have 2 options with charAt(j) we can use it or we can skip it
    // we can use it only if charAt(i) matches charAt(j)
    public boolean isMatchUtil(String s, String p, int i, int j) {

        if(i == s.length() && j == p.length()) {
            dp[i][j] = true;
            return true;
        }
        else if(j >= p.length()) {
            dp[i][j] = false;
            return false;
        }

        if(dp[i][j] != null) return dp[i][j];

        boolean isMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || '.' == p.charAt(j));

        if(j+1<p.length() && p.charAt(j+1) == '*') {
            //we dont use it
            dp[i][j] = isMatchUtil(s, p, i, j+2) ||
            //we use it
                    (isMatch && isMatchUtil(s, p, i+1, j));
            return dp[i][j];
        } else if(isMatch) {
            dp[i][j] = isMatchUtil(s, p, i+1, j+1);
            return dp[i][j];
        }

        dp[i][j] = false;
        return false;
    }
}