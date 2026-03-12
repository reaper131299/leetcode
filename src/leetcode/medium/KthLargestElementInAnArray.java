package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n : nums){
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
}
