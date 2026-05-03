package leetcode.medium;

import java.sql.Array;
import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args){
        MinCostToConnectAllPoints m = new MinCostToConnectAllPoints();
//        m.minCostConnectPoints(new int[][]{
//                {0,0},
//                {1,1},
//                {1,0},
//                {-1,1}
//        });

        m.minCostConnectPoints(new int[][]{
                {0,0},
                {2,2},
                {3,10},
                {7,2},
                {9,0}
        });
    }

    //This is prim's algorithm this algorith explores all the path, and proceeds ahead with path with minimum weight.
    public int minCostConnectPoints(int[][] points) {
        Map<int[], List<int[]>> graph = new HashMap<>();

        //key -> p1, value -> d,i (distance, index)
        for(int[] p1: points) {
            graph.computeIfAbsent(p1, k -> new ArrayList<>());
            for(int i = 0; i<points.length; i++) {
                if(p1 == points[i]) continue;
                int d = Math.abs(p1[0] - points[i][0]) + Math.abs(p1[1]-points[i][1]);
                graph.get(p1).add(new int[]{d, i});
            }
        }

        int res = 0;
        boolean[] visited = new boolean[points.length];
        int visitedCount = 0;
        PriorityQueue<int[]> pq  = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0});

        while (visitedCount < points.length) {
            int[] node = pq.poll();
            if(visited[node[1]]) continue;

            res += node[0];
            visited[node[1]] = true;
            visitedCount++;

            for(int[] nextNode : graph.get(points[node[1]])) {
                if (!visited[nextNode[1]]) {
                    pq.add(nextNode);
                }
            }
        }

        return res;
    }
}
