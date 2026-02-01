package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ClimbingStairs {

    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0,1,2,3));

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(3));
    }

    //using dp efificient but increases space complexity because os extra array
//    public int climbStairs(int n) {
//        int count = 0;
//        if (arr.size() > n) count = arr.get(n);
//        else {
//            count = climbStairs(n - 1) + climbStairs(n - 2);
//            arr.add(count);
//        }
//        return count;
//    }

    //efficient and uses very less space.
    public int climbStairs(int n) {
        if(n<=3) return n;
        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;
        for(int i = 3; i<n; i++){
            cur = prev1 +prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
