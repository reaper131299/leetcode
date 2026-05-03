package leetcode.medium;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime n = new NetworkDelayTime();
        n.networkDelayTime(new int[][]{
                {1,2,1},
                {1,3,1},
                {3,2,1}
        }, 3, 1);
    }

//    public int networkDelayTime(int[][] times, int n, int k) {
//        //key -> e[0], value -> e[1],e[2] (weight, index)
//        Map<Integer, List<int[]>> graph  = new HashMap<>();
//
//        for(int[] e: times) {
//            graph.computeIfAbsent(e[0], i -> new ArrayList<>());
//            graph.get(e[0]).add(new int[]{e[2], e[1]});
//        }
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        int res = 0;
//        Set<Integer> visited  = new HashSet<>();
//        pq.add(new int[]{0,k});
//
//        while (visited.size() < n && !pq.isEmpty()) {
//            int[] currNode = pq.poll();
//            int currTime = currNode[0];
//            res = Math.max(res, currTime);
//
//            if(visited.contains(currNode[1])) continue;
//
//            visited.add(currNode[1]);
//
//            List<int[]> nextNodes = graph.get(currNode[1]);
//            if(nextNodes == null || nextNodes.isEmpty()) {
//                continue;
//            }
//
//            for(int[] nextNode: nextNodes){
//                if(!visited.contains(nextNode[1])) {
//                    nextNode[0] += currTime;
//                    pq.add(nextNode);
//                }
//            }
//        }
//
//        if(visited.size() != n) return -1;
//        return res;
//    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //key -> e[0], value -> e[1],e[2] (weight, index)
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] e : times) {
            graph.computeIfAbsent(e[0], i -> new ArrayList<>());
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] weight = new int[n+1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        pq.add(new int[]{k,0});
        weight[k] = 0;

        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int currNodeIdx = currNode[0];
            int currWeight = currNode[1];

            if(currWeight > weight[currNodeIdx]) continue;

            if(graph.get(currNodeIdx) == null) continue;

            for(int[] nextNode : graph.get(currNodeIdx)) {
                int nextNodeIdx = nextNode[0];
                int nextNodeWeight = nextNode[1];

                if(nextNodeWeight + currWeight < weight[nextNodeIdx]) {
                    weight[nextNodeIdx] = nextNodeWeight + currWeight;
                    pq.add(new int[]{nextNodeIdx, weight[nextNodeIdx]});
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 1; i<weight.length; i++) {
            if(weight[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, weight[i]);
        }

        return res;
    }
}
