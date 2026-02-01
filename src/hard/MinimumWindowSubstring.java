package hard;

import java.util.*;
import java.util.stream.Stream;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        m.minWindow("caaabef", "abc");

    }

    public String minWindow(String s, String t) {
        //int need = t.length();
        //int having  = 0;
        //add chars from s
        //if t.map contains c update sMap counter
        //if s.map get count of ref < t.map get count of freq having ++
        //if iswondow valid remove left char check if wondow is valid remove again if yes add if not

        int tl = t.length();
        int sl = s.length();

        if(tl>sl) return "";

        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : tch){
            tMap.merge(c, 1, Integer::sum);
        }

        int need = t.length();
        int have = 0;
        int left = 0;
        int right = 0;
        boolean isWindowValid = true;
        int currMinWindow = Integer.MAX_VALUE;
        int finalLeft = 0;
        int finalRight = 0;
        boolean isfound = false;
        while (right<sl) {
            if(tMap.containsKey(sch[right])) {
                char cr = sch[right];
                sMap.merge(cr, 1, Integer::sum);
                if (sMap.get(cr) <= tMap.get(cr)) {
                    have++;
                }

                while (have == need) {
                    if(currMinWindow > right - left){
                        currMinWindow = right - left;
                        finalRight = right;
                        finalLeft = left;
                        isfound = true;
                    }
                    char cl = sch[left];
                    if(tMap.containsKey(cl)) {
                        sMap.merge(cl, -1, Integer::sum);
                        if (sMap.get(cl) < tMap.get(cl)) {
                            have--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        if(!isfound)
            return "";
        String finalStrin = s.substring(finalLeft, finalRight+1);
        return finalStrin;
    }
}
