package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char starchar = Character.toLowerCase(s.charAt(start));
            char endchar = Character.toLowerCase(s.charAt(end));
            if(!Character.isLetterOrDigit(starchar))
                start++;
            else if (!Character.isLetterOrDigit(endchar))
                end--;
            else {
                if (starchar != endchar) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
