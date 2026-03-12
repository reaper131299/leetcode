package leetcode.medium;

import java.util.*;

public class TaskScheduler {

    public static void main(String args[]){
        TaskScheduler t = new TaskScheduler();
        t.leastInterval(new char[]{'A','A','A','B','B','B'}, 2);

    }    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
        LinkedList<Integer> queue = new LinkedList<>();

        int[] count = new int[26];
        for(char ch : tasks){
            count[ch-'A']++;
        }

        for(int i : count){
            if(i!=0) pqueue.add(i);
        }

        int timer =0;
        while (!pqueue.isEmpty() || !queue.isEmpty()){
            timer++;
            if(!pqueue.isEmpty()) {
                int i = pqueue.poll();
                if(i-1 != 0) {
                    queue.add(i-1);
                    queue.add(timer + n);
                }

            }

            while (!queue.isEmpty() && timer>=queue.get(1)){
                pqueue.add(queue.poll());
                queue.poll();
            }
        }

        return timer;
    }


}
