package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram g = new GroupAnagram();
        g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chrs = s.toCharArray();
            char[] c= new char[26];
            for(char ch : chrs){
                c[ch-'a']++;
            }
            String st = String.valueOf(c);
            map.putIfAbsent(st, new ArrayList<>());
            map.get(st).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

