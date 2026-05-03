package leetcode.medium;

import java.util.*;

public class DetectSquares {

    List<int[]> list = new ArrayList<>();
    Map<String, Integer> freq = new HashMap<>();
    Set<Integer> xset = new HashSet<>();
    Set<Integer> yset = new HashSet<>();

    public static void main(String args[]){
        DetectSquares d = new DetectSquares();
        d.add(new int[]{5,10});
        d.add(new int[]{10,5});
        d.add(new int[]{10,10});
        d.count(new int[]{5,5});
        d.add(new int[]{3,0});
        d.add(new int[]{8,0});
        d.add(new int[]{8,5});
        d.count(new int[]{3,5});
        d.add(new int[]{9,0});
        d.add(new int[]{9,8});
        d.add(new int[]{1,8});
        d.count(new int[]{1,0});
        d.add(new int[]{0,0});
        d.add(new int[]{8,0});
        d.add(new int[]{8,8});
        d.count(new int[]{0,8});
        d.add(new int[]{1,9});
        d.add(new int[]{2,9});
        d.add(new int[]{2,10});
        d.count(new int[]{1,10});
        d.add(new int[]{7,8});
        d.add(new int[]{2,3});
        d.add(new int[]{2,8});
        d.count(new int[]{7,3});
        d.add(new int[]{9,10});
        d.add(new int[]{9,5});
        d.add(new int[]{4,5});
        d.count(new int[]{4,10});
        d.add(new int[]{0,9});
        d.add(new int[]{4,5});
        d.add(new int[]{4,9});
        d.count(new int[]{0,5});
        d.add(new int[]{1,10});
        d.add(new int[]{10,1});
        d.add(new int[]{10,10});
        d.count(new int[]{1,1});
        d.add(new int[]{10,0});
        d.add(new int[]{2,0});
        d.add(new int[]{2,8});
        d.count(new int[]{10,8});
        d.add(new int[]{7,6});
        d.add(new int[]{4,6});
        d.add(new int[]{4,9});
        d.count(new int[]{7,9});
        d.add(new int[]{10,9});
        d.add(new int[]{10,0});
        d.add(new int[]{1,0});
        d.count(new int[]{1,9});
        d.add(new int[]{0,9});
        d.add(new int[]{8,1});
    }

    public DetectSquares() {

    }

    public void add(int[] point) {
        String key = point[0] + "@" + point[1];
        if(!freq.containsKey(key)) list.add(point);
        freq.put(key, freq.getOrDefault(key, 0)+1);
        xset.add(point[0]);
        yset.add(point[1]);
    }

    public int count(int[] p1) {

        if(!xset.contains(p1[0]) || !yset.contains(p1[1])) return 0;

        int count = 0;
        for(int[] p2 : list) {
            if((p1[0] == p2[0] || p1[1] == p2[1]) || (Math.abs(p1[0] - p2[0]) != Math.abs(p1[1] - p2[1])))
                continue;
            count += freq.getOrDefault(p2[0] + "@" + p2[1], 0) * freq.getOrDefault(p1[0] + "@" + p2[1], 0) * freq.getOrDefault(p2[0] + "@" + p1[1], 0);
        }

        return count;
    }
}
