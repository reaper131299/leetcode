package leetcode.hard;

import java.util.*;

import static leetcode.easy.BalancedBinaryTree.dfs;

public class AlienDictionary {

    Boolean[] visited = new Boolean[26];
    LinkedList<Character> res = new LinkedList<>();
    Map<Character, Set<Character>> graph = new HashMap<>();

    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();
        a.foreignDictionary(new String[]{"wrtkj", "wrt"});
    }

//    public String foreignDictionary(String[] words) {
//        if (words.length == 1) return words[0];
//
//        for (String word : words) {
//            for (char c : word.toCharArray()) {
//                graph.computeIfAbsent(c, k -> new HashSet<>());
//            }
//        }
//
//        for (int i = 1; i < words.length; i++) {
//            String s1 = words[i - 1];
//            String s2 = words[i];
//
//            int minLength = Math.min(s1.length(), s2.length());
//            if (s2.substring(0, minLength).equals(s1.substring(0, minLength)) && s1.length() > s2.length()) {
//                return "";
//            }
//
//
//            int idx1 = 0;
//            int idx2 = 0;
//
//            while (idx1 < s1.length() && idx2 < s2.length()) {
//                if (s1.charAt(idx1) != s2.charAt(idx2)) {
//                    graph.get(s1.charAt(idx1)).add(s2.charAt(idx2));
//                    break;
//                }
//                idx1++;
//                idx2++;
//            }
//        }
//
//        for (Character c : graph.keySet()) {
//            if (dfs(c)) {
//                return "";
//            }
//        }
//
//        return convertToRes(res);
//    }

    public String foreignDictionary(String[] words) {
        if (words.length == 1) return words[0];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];

            int minLength = Math.min(s1.length(), s2.length());
            if (s2.substring(0, minLength).equals(s1.substring(0, minLength)) && s1.length() > s2.length()) {
                return "";
            }


            int idx = 0;

            while (idx < minLength) {
                if (s1.charAt(idx) != s2.charAt(idx)) {
                    graph.get(s2.charAt(idx)).add(s1.charAt(idx));
                    break;
                }
                idx++;
            }
        }

        for (Character c : graph.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        return convertToRes(res);
    }

    private String convertToRes(LinkedList<Character> res) {
        char[] ch = new char[res.size()];

        int idx = 0;
        for (Character c : res) {
            ch[idx] = c;
            idx++;
        }

        return new String(ch);
    }

    public boolean dfs(char ch) {
        if (visited[ch - 'a'] != null) return visited[ch - 'a'];

        visited[ch - 'a'] = true;
        for (Character c : graph.get(ch)) {
            if (dfs(c)) {
                return true;
            }
        }
        visited[ch - 'a'] = false;
        res.add(ch);

        return false;
    }
}
