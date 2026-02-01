package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> mapOfInts = new HashSet<>();
        for(int i :nums)
            mapOfInts.add(i);

        return mapOfInts.size() != nums.length;
    }
}