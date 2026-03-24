package leetcode.medium;

import java.util.Arrays;
import java.util.Set;

public class RedundantConnection {
    Set<Integer>[] set;
    int[] parent;
    private int[] rank;

//    public int[] findRedundantConnection(int[][] edges) {
//        set = new Set[edges.length+1];
//        for(int[] i : edges){
//            Set<Integer> a = set[i[0]] == null ? new HashSet<>() : set[i[0]];
//            Set<Integer> b = set[i[1]] == null ? new HashSet<>() : set[i[1]];
//            if(a==b){
//                return i;
//            }
//            a.add(i[0]);
//            a.add(i[1]);
//            a.addAll(b);
//
//            set[i[0]] = a;
//            set[i[1]] = a;
//            for(int n : b){
//                set[n] = a;
//            }
//        }
//        return new int[]{-1, -1};
//    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i = 0; i<edges.length+1; i++){
            parent[i] = i;
        }
        int[] weight = new int[edges.length+1];
        Arrays.fill(weight, 1);

        for(int[] n : edges){
            int a = n[0];
            int b = n[1];

            int aParent = findParent(a);
            int bParent = findParent(b);

            if(aParent == bParent){
                return n;
            }

            int aWeight = weight[aParent];
            int bWeight = weight[bParent];

            if(bWeight > aWeight){
                weight[bParent] = bWeight+aWeight;
                parent[aParent] = bParent;
            } else {
                weight[aParent] = bWeight+aWeight;
                parent[bParent] = aParent;
            }
        }

        return new int[]{-1, -1};
    }

    public int findParent(int c){
        int p = parent[c];

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public static void main(String args[]) {
        RedundantConnection r = new RedundantConnection();
        r.findRedundantConnection(new int[][]{
                {1, 2},
                {5, 6},
                {3, 4},
                {7, 8},
                {2, 4},
                {6, 8},
                {4, 5},
                {5, 7}
        });
    }

}
