package leetcode.easy;

public class MinCostClimbingStairs {

    Integer[] costs;
    int[] cost;
    int totalSteps;

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        costs = new Integer[cost.length];
        totalSteps = cost.length;
        costs[cost.length - 1] = cost[cost.length - 1];
        costs[cost.length - 2] = cost[cost.length - 2];
        return Math.min(findMinCost(0), findMinCost(1));
    }

    private int findMinCost(int start) {
        if (start > totalSteps - 1)
            return 0;
        if (costs[start] != null) return costs[start];
        int count = Math.min(findMinCost(start + 1), findMinCost(start + 2))+cost[start];
        costs[start] = count;
        return count;
    }
}
