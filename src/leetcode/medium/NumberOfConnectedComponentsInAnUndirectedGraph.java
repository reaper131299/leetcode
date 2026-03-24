package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(){

    }

//    public int countComponents(int num, int[][] edges) {
//        Set<Integer>[] map = new Set[num];
//
//        for(int[] n : edges){
//            Set<Integer> a = map[n[0]] == null ? new HashSet<>() :  map[n[0]];
//            Set<Integer> b = map[n[1]] == null ? new HashSet<>() :  map[n[1]];
//
//            a.add(n[0]);
//            map[n[0]] = a;
//
//            b.add(n[1]);
//            a.addAll(b);
//            for(int i : b){
//                map[i] = a;
//            }
//        }
//
//        int count = 0;
//        Set<Set<Integer>> fset = new HashSet<>();
//        for(Set<Integer> s : map){
//            if(s !=null && !s.isEmpty()){
//                fset.add(s);
//            } else {
//                count++;
//            }
//        }
//
//        return fset.size() + count;
//    }

    int[] parent;
    int[] weight;

    public int countComponents(int num, int[][] edges) {
        parent = new int[num];
        weight = new int[num];

        for(int i = 0; i<num; i++){
            parent[i] = i;
            weight[i] = 0;
        }

        for(int[] n : edges){
            int a = n[0];
            int b = n[1];

            int aParent = findParent(a);
            int bParent = findParent(b);

            int aWeight = weight[aParent];
            int bWeight = weight[bParent];

            if (bWeight > aWeight) {
                parent[aParent] = bParent;
                weight[b] = bWeight + aWeight;
            } else {
                parent[bParent] = aParent;
                weight[b] = bWeight + aWeight;
            }
        }

        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<parent.length; i++){
            s.add(findParent(i));
        }

        return s.size();
    }

    private int findParent(int c) {
        int p = parent[c];

        while (p != parent[p]){
            p = parent[p];
        }

        return p;
    }

}
