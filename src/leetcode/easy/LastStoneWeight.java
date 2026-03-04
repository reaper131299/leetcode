package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {
    PriorityQueue<Integer> p;

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[]{2, 4, 1, 1, 1}));
    }

//    public int lastStoneWeight(int[] stones) {
//        this.currSize = stones.length;
//        arr = stones;
//        createHeap();
//        playGame();
//        return stones[0];
//    }
//
//    private void playGame() {
//        if(currSize<=1) return;
//        int firstStone = arr[0];
//        int secondStone = 0;
//        if(currSize ==2) secondStone = arr[1];
//        else secondStone = Math.max(arr[1], arr[2]);
//        if(firstStone == secondStone) {
//            //remove1st stone
//            arr[0] = arr[currSize-1];
//            arr[currSize-1] = 0;
//            heapDown(0);
//            currSize--;
//            //remove 2nd stone
//            arr[0] = arr[currSize-1];
//            arr[currSize-1] = 0;
//            heapDown(0);
//            currSize--;
//        } else {
//            int weightRemaining = Math.abs(firstStone - secondStone);
//            //remove1st stone
//            arr[0] = arr[currSize-1];
//            arr[currSize-1] = 0;
//            heapDown(0);
//            currSize--;
//            //remove 2nd stone
//            arr[0] = arr[currSize-1];
//            arr[currSize-1] = 0;
//            heapDown(0);
//            arr[currSize-1] = weightRemaining;
//            heapUp(currSize);
//        }
//        playGame();
//    }
//

    /// /    private void reverseArray(int[] stones) {
    /// /        int l = 0;
    /// /        int r = stones.length-1;
    /// /        while(l < r){
    /// /            int temp = stones[l];
    /// /            stones[l] = stones[r];
    /// /            stones[r] = temp;
    /// /            l++;
    /// /            r--;
    /// /        }
    /// /    }
//
//    //to heapify whole tree start with last non leaf node and work up the tree for each node
//    // if the tree is already heapified then use heap down if the new value is added at the top
//    //use heap up is new value is added at the bottom of the tree
//    private void createHeap(){
//        for(int i = currSize/2-1;i>=0; i--){
//            heapDown(i);
//        }
//    }
//
//    private void heapUp(int i){
//        int parent = i / 2 - 1;
//        if(i >= 2 && arr[i-1]>arr[parent]){
//            int temp = arr[i-1];
//            arr[i-1] = arr[parent];
//            arr[parent] = temp;
//            heapUp(parent+1);
//        }
//    }
//
//    private void heapDown(int root){
//        int gratest = root;
//        int left = root*2+1;
//        int right = root*2+2;
//
//        if(left<currSize && arr[gratest] <arr[left])
//            gratest = left;
//        if(right<currSize && arr[gratest] <arr[right])
//            gratest = right;
//
//        if(gratest!=root){
//            int temp = arr[root];
//            arr[root] = arr[gratest];
//            arr[gratest] = temp;
//            heapDown(gratest);
//        }
//    }

    // using priority queue slower than heap
    public int lastStoneWeight(int[] stones) {
        p = new PriorityQueue<>(Collections.reverseOrder());
        p.addAll(Arrays.stream(stones).boxed().collect(Collectors.toCollection(ArrayList::new)));
        while (p.size() > 1) {
            play();
        }
        return !p.isEmpty() ? p.poll() : 0;
    }

    private void play() {
        int i = p.poll();
        int j = p.poll();
        int weightRemaining = Math.abs(i - j);
        if (weightRemaining != 0) {
            p.add(weightRemaining);
        }
    }
}
