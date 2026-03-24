package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();
    String s;

    public static void main(String[] args){
        PalindromePartitioning p = new PalindromePartitioning();
        p.partition("aab");
    }

    public List<List<String>> partition(String s) {
        this.s = s;
        partitionUtil(0, new ArrayList<>());
        return res;
    }

    public void partitionUtil(int pos, List<String> arr) {
        if(pos == s.length()){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i = pos; i<s.length(); i++){
            String substring = s.substring(pos, i+1);
            if(isSubstringPalindrome(substring)) {
                arr.add(substring);
                partitionUtil(i+1, arr);
                arr.removeLast();
            }
        }
    }

    private boolean isSubstringPalindrome(String substring) {
        int left = 0;
        int right = substring.length()-1;
        while(left<=right){
            if(substring.charAt(left) != substring.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
