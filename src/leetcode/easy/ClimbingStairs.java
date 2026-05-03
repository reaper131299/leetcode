package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ClimbingStairs {
    int[] minSteps;

    public static void main(String args[]){
        ClimbingStairs c = new ClimbingStairs();
        c.climbStairs(6);
    }

//    public int climbStairs(int n) {
//        minSteps = new int[n+1];
//        Arrays.fill(minSteps, -1);
//        return climbStairsUtil(n);
//    }
//
//    public int climbStairsUtil(int n) {
//        if(n<=3 ) {
//            minSteps[n] = n;
//            return n;
//        }
//
//        if(minSteps[n] != -1) return minSteps[n];
//
//        int steps = climbStairsUtil(n-1) + climbStairsUtil(n-2);
//
//        minSteps[n] = steps;
//
//        return steps;
//
//    }

    public int climbStairs(int n) {
        if(n<=3) return n;

        int[] totalWays = new int[n+1];
        totalWays[0] = 0;
        totalWays[1] = 1;
        totalWays[2] = 2;
        totalWays[3] = 3;

        for(int i = 4; i<=n; i++){
            totalWays[i] = totalWays[i-1]+totalWays[i-2];
        }

        return totalWays[n];
    }
}
