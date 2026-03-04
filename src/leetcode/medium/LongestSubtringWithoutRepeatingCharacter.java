package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubtringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        LongestSubtringWithoutRepeatingCharacter l = new LongestSubtringWithoutRepeatingCharacter();
        l.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = right;
        int maxSize = 0;
        while(right<n){
            if(!set.contains(ch[right])){
                set.add(ch[right]);
                right++;
            } else {
                maxSize = Math.max(set.size(), maxSize);
                set.remove(ch[left]);
                left++;
            }
        }
        maxSize = Math.max(set.size(), maxSize);
        return maxSize;
    }
}
