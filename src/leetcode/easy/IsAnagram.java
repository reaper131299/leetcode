package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {
        isAnagram("rat","car");

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> charCountMap1 = new HashMap<>();
        HashMap<Character, Integer> charCountMap2 = new HashMap<>();

        for (char ch1 : s.toCharArray())
            charCountMap1.put(ch1, charCountMap1.getOrDefault(ch1, 0) + 1);

        for (char ch2 : t.toCharArray())
            charCountMap2.put(ch2, charCountMap2.getOrDefault(ch2, 0) + 1);

        for (Map.Entry<Character, Integer> entry : charCountMap1.entrySet())
            if (!(charCountMap2.containsKey(entry.getKey()) && charCountMap2.get(entry.getKey()).equals(entry.getValue())))
                return false;

        return true;
    }
}
