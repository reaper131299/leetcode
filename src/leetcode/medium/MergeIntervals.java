package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]- b[0]);

        List<int[]> newIntervals = new ArrayList<>();
        int[] prevInterval = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]<=prevInterval[1]) {
                prevInterval[0] = Math.min(intervals[i][0], prevInterval[0]);
                prevInterval[1] = Math.max(intervals[i][1], prevInterval[1]);
            } else {
                newIntervals.add(prevInterval);
                prevInterval = intervals[i];
            }
        }
        newIntervals.add(prevInterval);

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}
