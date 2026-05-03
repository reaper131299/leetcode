package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReplaceTheSubstringForBalancedString {

    public static void main(String args[]) {
        ReplaceTheSubstringForBalancedString r = new ReplaceTheSubstringForBalancedString();
        r.balancedString("WQWRQQQW");
    }

//    public int balancedString(String s) {
//        int[] map = new int[26];
//        int res = Integer.MAX_VALUE;
//        char[] chars = s.toCharArray();
//
//        for(char c : s.toCharArray()) {
//            map[c-'A']++;
//        }
//
//        int l = 0;
//        int r = 0;
//        int expectedCount = s.length()/4;
//
//        while (r<s.length()) {
//            map[chars[r]-'A']--;
//
//            while (l<=r+1 && l<s.length() && map['Q'-'A'] <= expectedCount && map['W' -'A'] <= expectedCount
//            && map['E' -'A'] <= expectedCount && map['R' -'A'] <= expectedCount) {
//                res = Math.min(res, r-l+1);
//                map[chars[l]-'A']++;
//                l++;
//            }
//
//            r++;
//        }
//
//
//        return res;
//    }

    public int balancedString(String s) {
        int missMatched = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = s.length();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int expectedCharCount = s.length() / 4;
        Set<Character> missMatchedSet = new HashSet<>();
        Map<Character, Integer> missMatchedMap = new HashMap<>();

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() - expectedCharCount > 0) {
                missMatched = missMatched + (e.getValue() - expectedCharCount);
                missMatchedSet.add(e.getKey());
                missMatchedMap.put(e.getKey(), e.getValue() - expectedCharCount);
            }
        }

        int l = 0;
        int r = 0;

        Map<Character, Integer> matchedMap = new HashMap<>();
        for (Map.Entry<Character, Integer> e : missMatchedMap.entrySet()) {
            matchedMap.put(e.getKey(), 0);
        }
        while (r < s.length()) {
            if (missMatchedSet.contains(s.charAt(r))) {
                matchedMap.put(s.charAt(r), matchedMap.getOrDefault(s.charAt(r), 0) + 1);

                while (l<=r && checkIfWindowIsValid(missMatchedMap, matchedMap)) {
                    if (missMatchedSet.contains(s.charAt(l))) {
                        matchedMap.put(s.charAt(l), matchedMap.get(s.charAt(l)) - 1);
                        res = Math.min(res, r - l + 1);
                    }
                    l++;
                }
            }
            r++;
        }

        return res;
    }

    public boolean checkIfWindowIsValid(Map<Character, Integer> missMatcehdMap, Map<Character, Integer> matchedMap) {
        for (Map.Entry<Character, Integer> e : matchedMap.entrySet()) {
            if (e.getValue() < missMatcehdMap.get(e.getKey())) return false;
        }
        return true;
    }

}
