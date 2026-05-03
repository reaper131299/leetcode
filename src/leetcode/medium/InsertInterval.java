package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertInterval {

    public static void main(String args[]){
        InsertInterval i = new InsertInterval();
        i.insert(new int[][]{
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        }, new int[]{4,8});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> newIntervals = new ArrayList<>();

        for(int i = 0; i< intervals.length; i++) {
            if(newInterval[0] > intervals[i][1]) {
                newIntervals.add(intervals[i]);
            } else if (newInterval[1] < intervals[i][0]) {
                newIntervals.add(newInterval);
                return addRestElements(newIntervals, intervals, i);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        newIntervals.add(newInterval);

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }

    private int[][] addRestElements(List<int[]> newIntervals, int[][] intervals, int i) {
        for(; i<intervals.length ; i++){
            newIntervals.add(intervals[i]);
        }
        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}
