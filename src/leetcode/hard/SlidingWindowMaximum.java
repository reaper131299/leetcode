package leetcode.hard;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) throws IOException {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.maxSlidingWindow(new int[]{1} , 1);
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for(int i =0;i<k;i++){
//            pq.add(nums[i]);
//        }
//
//        int left = 0;
//        int right = k-1;
//
//        int[] res = new int[nums.length-k+1];
//        int resIdx = 0;
//        while (right<nums.length){
//            res[resIdx] = pq.peek();
//            right++;
//            left++;
//            pq.remove(nums[left-1]);
//            if(right<nums.length)
//                pq.add(nums[right]);
//            resIdx++;
//        };
//        return res;
//    }

    public int[] maxSlidingWindow(int[] nums, int k){
        // we will store indexes in this deque because we have to we will need index to remove the elements that are outside the window.
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i = 0; i<n;i++){
            //when the slide moves right remove the left element, index of that element can be counted by i-k
            //for example k = 3; when window moved from i = 2, index[0,2] -> i = 3 index[1,3] we have to remove 0th index so i-k -> 3-k = 0;
            if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            //while numbers in the dequeue are less than the number we are trying to add remove the number from the deque.
            while(!deque.isEmpty() && nums[i]>nums[deque.getLast()]){
                deque.pollLast();
            }
            //after removing all the digits that are less that the digit we are trying to add we are left with the max digit at the front of the deque.
            deque.addLast(i);
            if(i>=k-1) res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
