package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {

    public static void main(String args[]){
        NonOverlappingIntervals n = new NonOverlappingIntervals();
        n.eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {-100,-2},
                {5,7}
        });
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] prevInterval = intervals[0];

        int count = 0;

        for(int i = 1; i<intervals.length; i++){
            if(prevInterval[1] > intervals[i][0]) {
                count++;
                if(intervals[i][1] < prevInterval[1]) {
                    prevInterval = intervals[i];
                }
            } else {
                prevInterval = intervals[i];
            }
        }
        return count;
    }
}
