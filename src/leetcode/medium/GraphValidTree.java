package leetcode.medium;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;
import java.util.Set;

public class GraphValidTree {


//    public boolean validTree(int num, int[][] edges) {
//        Set<Integer>[] map = new Set[num];
//
//        if(edges.length == 0 && num==1) return true;
//
//        for(int[] n : edges){
//            if(n[0] == n[1]) return false;
//
//            Set<Integer> a = map[n[0]] == null ? new HashSet<>() : map[n[0]];
//            Set<Integer> b = map[n[1]] == null ? new HashSet<>() : map[n[1]];
//
//            if(a == b) return false;
//
//            a.add(n[0]);
//            map[n[0]] = a;
//
//            b.add(n[1]);
//            a.addAll(b);
//
//            for (int i : b){
//                map[i] = a;
//            }
//        }
//
//        Set<Set<Integer>> fset = new HashSet<>();
//        for(Set<Integer> s : map){
//            if(s ==null || s.isEmpty()){
//                return false;
//            } else {
//                fset.add(s);
//            }
//        }
//
//        return fset.size() == 1;
//    }

    public static void main(String args[]){
        GraphValidTree g = new GraphValidTree();
        g.validTree(5, new int [][]{
            {0,1},
            {0,2},
            {0,3},
            {1,4}
        });

    }

    int[] parent;
    int[] weight;
    public boolean validTree(int num, int[][] edges) {
        parent = new int[num];
        weight = new int[num];
        for(int i = 0; i< num; i++){
            parent[i] = i;
            weight[i] = 1;
        }

        for(int[] n : edges){
            int a = n[0];
            int b = n[1];

            int aParent = findParent(a);
            int bParent = findParent(b);

            if(aParent == bParent) return false;

            int aWeight = weight[aParent];
            int bWeight = weight[bParent];

            if(bWeight > aWeight){
                parent[aParent] = bParent;
                weight[b] = bWeight+aWeight;
            } else {
                parent[bParent] = aParent;
                weight[a] = aWeight+bWeight;
            }
        }

        int fParent = findParent(0);
        for(int i = 1; i <parent.length; i++){
            if(fParent != findParent(i)){
                return false;
            }
        }
        return true;
    }

    private int findParent(int c) {
        int p = parent[c];

        while (p != parent[p]){
            p = parent[p];
        }

        return p;
    }
}
