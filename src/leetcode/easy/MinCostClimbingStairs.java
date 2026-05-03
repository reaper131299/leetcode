package leetcode.easy;

import java.util.Arrays;

public class MinCostClimbingStairs {
    int[] cost;
    int[] minCostForStair;

    public static void main(String args[]){
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
    }

//    public int minCostClimbingStairs(int[] cost) {
//        if(cost.length == 2) return Math.min(cost[0], cost[1]);
//
//        this.cost =cost;
//        minCostForStair = new int[cost.length];
//        Arrays.fill(minCostForStair, -1);
//        minCostClimbingStairsUtil(0);
//
//        return Math.min(minCostForStair[0], minCostForStair[1]);
//    }
//
//    public int minCostClimbingStairsUtil(int n){
//        if(n>=cost.length) return 0;
//
//        if(n>=cost.length-2) {
//            minCostForStair[n] = cost[n];
//            return cost[n];
//        }
//
//        if(minCostForStair[n]!=-1) return minCostForStair[n];
//
//        int costWithNextStep = cost[n] + minCostClimbingStairsUtil(n+1);
//        int costBySkippingNextStep = cost[n] + minCostClimbingStairsUtil(n+2);
//
//        minCostForStair[n] = Math.min(costWithNextStep, costBySkippingNextStep);
//
//        return minCostForStair[n];
//    }

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[cost.length-1] = cost[cost.length-1];
        minCost[cost.length-2] = cost[cost.length-2];
        for(int i = cost.length-3; i>=0; i--){
            minCost[i] = cost[i] + Math.min(minCost[i+1], minCost[i+2]);
        }

        return Math.min(minCost[0], minCost[1]);
    }
}
