package medium;

import jdk.jfr.Frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        p.checkInclusion("hello", "ooolleoooleh");
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;

        int counter = s1.length();

        int[] arr = new int[26];
        for (char c : s1.toCharArray()) {
            arr[c-'a']--;
        }

        int ls1 = s1.length();
        int ls2 = s2.length();

        int mismatched = s1.length();
        int left = 0;
        int right = 0;
        char[] ch = s2.toCharArray();

        while (right<ls2){
            if(right<ls1){
                arr[ch[right]-'a']++;
                if(arr[ch[right]-'a']<=0){
                    mismatched--;
                }
                right++;
            } else {
                arr[ch[right]-'a']++;
                if(arr[ch[right]-'a']<=0){
                    mismatched--;
                }
                arr[ch[left]-'a']--;
                if(arr[ch[left]-'a']<0){
                    mismatched++;
                }
                right++;
                left++;
            }
            if(mismatched == 0)
                return true;
        }
        return false;
    }
//    public boolean checkInclusion(String s1, String s2) {
//        if(s2.length()<s1.length())
//            return false;
//
//        Map<Character, Integer> s1Map = new HashMap<>();
//        for(char c: s1.toCharArray()){
//            s1Map.merge(c, 1, Integer::sum);
//        }
//
//        int left = 0;
//        int right = left+s1.length();
//        Map<Character, Integer> s2Map = new HashMap<>();
//        for(int i = 0; i<right;i++){
//            s2Map.merge(s2.charAt(i), 1, Integer::sum);
//        }
//
//        while (right<s2.length()){
//            if(s2Map.equals(s1Map))
//                return true;
//            if(s2Map.get(s2.charAt(left))==1){
//                s2Map.remove(s2.charAt(left));
//            } else
//                s2Map.merge(s2.charAt(left), -1, Integer::sum);
//            s2Map.merge(s2.charAt(right), 1, Integer::sum);
//            left++;
//            right++;
//        }
//        if(s2Map.equals(s1Map))
//            return true;
//        return false;
//    }


//    public boolean checkInclusion(String s1, String s2) {
//        int ls1 = s1.length();
//        int ls2 = s2.length();
//        Set<Character> ch = new HashSet<>();
//        Map<Character, Integer> s1Map = new HashMap<>();
//        for (char c : s1.toCharArray()) {
//            s1Map.merge(c, 1, Integer::sum);
//        }
//        for (char c : s1.toCharArray()) {
//            ch.add(c);
//        }
//
//        boolean doesContain = false;
//
//        for (int i = 0; i <=ls2-ls1; i++) {
//            if (!ch.contains(s2.charAt(i))) continue;
//
//            boolean doesCOntainAllch = true;
//            for (int j = i; j < i + ls1; j++) {
//                if (!ch.contains(s2.charAt(j))) {
//                    doesCOntainAllch = false;
//                    break;
//                }
//            }
//            if(doesCOntainAllch) {
//                Map<Character, Integer> s2Map = new HashMap<>();
//                for (int j = i; j < i + ls1; j++) {
//                    s2Map.merge(s2.charAt(j), 1, Integer::sum);
//                }
//                doesContain = s2Map.equals(s1Map);
//                if (doesContain) break;
//            }
//        }
//        return doesContain;
//    }
}
