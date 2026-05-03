package leetcode.medium;

public class LongestPalindromicSubstring {
    int count = 0;
    String s;

    public int countSubstrings(String s) {
        this.s = s;
        for(int i = 0; i<s.length(); i++){
            longestPalindrome(i,i);
            longestPalindrome(i,i+1);
        }
        return count;
    }

    public void longestPalindrome(int l, int r) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}
