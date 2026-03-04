package leetcode.easy;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char x: s.toCharArray()){
            freq[x-'a']++;
        }
        for(char y: t.toCharArray()){
            freq[y-'a']--;
        }
        for(int x:freq){
            if(x!=0)    return false;
        }
        return true;
    }

}
