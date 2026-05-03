package leetcode.medium;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        c.findCheapestPrice(5, new int[][]{
                {0,1,5},
                {1,2,5},
                {0,3,2},
                {1,4,1},
                {4,2,1},
                {3,1,2}
        }, 0, 2, 2);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i = 0; i<k+1; i++) {
            int[] costCopy = new int[n];
            System.arraycopy(cost,0, costCopy, 0, n);
            for(int[] f : flights) {
                if(cost[f[0]] == Integer.MAX_VALUE) continue; //if Integer.MAX_VALUE means that this node is not visited yet so we skip outbound edges from it
                if(f[2]+cost[f[0]] < costCopy[f[1]]) { //node is visited and the new weight in less that old so update it.
                    costCopy[f[1]] = f[2]+cost[f[0]];
                }
            }
            cost = costCopy;
        }

        if(cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }


    //    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Map<Integer, List<int[]>> graph = new HashMap<>();
//
//        for(int[] f: flights) {
//            graph.computeIfAbsent(f[0], key -> new ArrayList<>());
//            graph.get(f[0]).add(new int[]{f[1], f[2]});
//        }
//
//        for(int i = 0; i<n; i++) {
//            graph.computeIfAbsent(i, key -> new ArrayList<>());
//        }
//
//        int[][] cost = new int[n][k+2];
//        for(int[] arr : cost) {
//            Arrays.fill(arr, Integer.MAX_VALUE);
//        }
//        cost[src][0] = 0;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        pq.add(new int[]{src, 0, 0});
//
//        while (!pq.isEmpty()) {
//            int[] currNode = pq.poll();
//            int currNodeIdx = currNode[0];
//            int currNodeCost = currNode[1];
//            int currStopsCount = currNode[2];
//
//            if(currNodeIdx == dst) return currNodeCost;
//            if(currStopsCount > k) continue;
//            if(currNodeCost > cost[currNodeIdx][currStopsCount]) continue;
//
//            for(int[] nextNode : graph.get(currNodeIdx)) {
//                int nextNodeIdx = nextNode[0];
//                int nextNodeCost = nextNode[1];
//
//                if(currNodeCost + nextNodeCost < cost[nextNodeIdx][currStopsCount+1]) {
//                    cost[nextNodeIdx][currStopsCount+1] = currNodeCost + nextNodeCost;
//                    pq.add(new int[]{nextNodeIdx, currNodeCost + nextNodeCost, currStopsCount + 1});
//                }
//            }
//        }
//        return -1;
//    }
}
