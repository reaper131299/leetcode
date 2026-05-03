package leetcode.medium;

public class InterleavingString {

    String s1;
    String s2;
    String s3;

    Boolean[][] dp;

    public static void main(String args[]){
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

//        InterleavingString i2 = new InterleavingString();
//        System.out.println(i2.isInterleave("aabcc", "dbbca", "aadbbczcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return interleave(0, 0, 0);
    }

    public boolean interleave(int idx1, int idx2, int idx3) {
        boolean isInterleave1 = false;
        boolean isInterleave2 = false;

        if(dp[idx1][idx2] != null) return dp[idx1][idx2];

        if(idx3 == s3.length() && idx1 == s1.length() && idx2 == s2.length()) {
            dp[idx1][idx2] = true;
            return true;
        }

        if(idx1<s1.length() && idx3<s3.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            isInterleave1 = interleave(idx1+1, idx2, idx3+1);
        }

        if(isInterleave1) {
            dp[idx1][idx2] = true;
            return true;
        }

        if(idx2<s2.length() && idx3<s3.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            isInterleave2 = interleave(idx1, idx2+1, idx3+1);
        }

        dp[idx1][idx2] = isInterleave2;
        return isInterleave2;
    }
}





