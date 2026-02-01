package medium;

import java.util.*;

//public class GroupAnagrams {
//
//    public static void main(String[] args) {
//        GroupAnagrams g = new GroupAnagrams();
//        List<List<String>> result = g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
//        System.out.println("exit");
//    }
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        LinkedList<Mapping> list = new LinkedList<>();
//        List<List<String>> result = new ArrayList<>();
//        for(String str : strs){
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            list.add(new Mapping(str,chars));
//        }
//        while(!list.isEmpty()){
//            char[] firstChars = list.getFirst().c;
//            List<String> group = new ArrayList<>();
//            group.add(String.valueOf(firstChars));
//            group.removeFirst();
//            Iterator<Mapping> i = list.iterator();
//            while (i.hasNext()){
//                Mapping next = i.next();
//                if(Arrays.equals(firstChars,next.c)){
//                    group.add(next.s);
//                    i.remove();
//                }
//            }
//            result.add(group);
//        }
//        return result;
//    }
//}
//
//class Mapping{
//    String s;
//    char [] c;
//    Mapping(String s, char[] c){
//        this.s = s;
//        this.c = c;
//    }
//}

//public class GroupAnagrams {
//
//    public static void main(String[] args) {
//        GroupAnagrams g = new GroupAnagrams();
//        List<List<String>> result = g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
//        System.out.println("exit");
//    }
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        for(String s : strs){
//            char[] chrs = s.toCharArray();
//            Arrays.sort(chrs);
//            String sorted = String.valueOf(chrs);
//            map.putIfAbsent(sorted, new ArrayList<>());
//            map.get(sorted).add(s);
//        }
//        return new ArrayList<>(map.values());
//    }
//}

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> result = g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("exit");
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

