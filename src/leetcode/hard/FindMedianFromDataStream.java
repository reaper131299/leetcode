package leetcode.hard;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    ArrayList<Integer> arrLeft;
    ArrayList<Integer> arrRight;
    int leftCounter = 0;
    int rightCounter = 0;

    public static void main(String args[]){
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
        medianFinder.addNum(78);    // arr = [1]
        medianFinder.addNum(14);    // arr = [1, 2]
        medianFinder.addNum(50);    // arr[1, 2, 3]
        medianFinder.addNum(20);    // arr[1, 2, 3]
        medianFinder.addNum(13);    // arr[1, 2, 3]
        medianFinder.addNum(9);    // arr[1, 2, 3]
        medianFinder.addNum(25);    // arr[1, 2, 3]
        medianFinder.addNum(8);    // arr[1, 2, 3]
        medianFinder.addNum(13);    // arr[1, 2, 3]
        medianFinder.addNum(37);    // arr[1, 2, 3]
        medianFinder.addNum(29);    // arr[1, 2, 3]
        medianFinder.addNum(35);    // arr[1, 2, 3]
        medianFinder.addNum(55);    // arr[1, 2, 3]
        medianFinder.addNum(52);    // arr[1, 2, 3]
//        medianFinder.findMedian(); // return 2.0
    }

//    public FindMedianFromDataStream() {
//        arrLeft = new ArrayList<>(25000);
//        arrRight = new ArrayList<>(25000);
//    }
//
//    public void addNum(int num) {
//        if(leftCounter == 0 ) {
//            leftCounter++;
//            arrLeft.add(num);
//            return;
//        }
//        if(leftCounter>rightCounter){
//            if(num>=arrLeft.getFirst()){
//                arrRight.add(num);
//                minHeapifyUp(arrRight, arrRight.size()-1);
//            }
//            else {
//                arrRight.add(arrLeft.getFirst());
//                arrLeft.set(0, num);
//                minHeapifyUp(arrRight, arrRight.size()-1);
//                maxHeapifyDown(arrLeft, 0);
//            }
//            rightCounter++;
//        } else if(leftCounter==rightCounter){
//            if(num<=arrRight.getFirst()){
//                arrLeft.add(num);
//                maxHeapifyUp(arrLeft, arrLeft.size()-1);
//            }
//            else{
//                arrLeft.add(arrRight.getFirst());
//                arrRight.set(0, num);
//                maxHeapifyUp(arrLeft, arrLeft.size()-1);
//                minHeapifyDown(arrRight, 0);
//            }
//            leftCounter++;
//        }
//
//    }
//
//    private void maxHeapifyUp(ArrayList<Integer> arr, int pos) {
//        if(pos == 0) return;
//        int parent = (pos-1)/2;
//        if(arr.get(parent)<arr.get(pos)){
//            int temp = arr.get(parent);
//            arr.set(parent, arr.get(pos));
//            arr.set(pos, temp);
//            maxHeapifyUp(arr, parent);
//        }
//    }
//
//    private void maxHeapifyDown(ArrayList<Integer> arr, int pos) {
//        if(pos>arr.size()-1) return;
//        int parent = pos;
//        int child1 = pos*2+1;
//        int child2 = pos*2+2;
//        int max = parent;
//        if(child1<arr.size() && arr.get(child1)>arr.get(max)){
//            max = child1;
//        }
//        if(child2<arr.size() && arr.get(child2)>arr.get(max)){
//            max = child2;
//        }
//        if(max!=parent && arr.get(max)>arr.get(parent)){
//            int temp = arr.get(parent);
//            arr.set(parent, arr.get(max));
//            arr.set(max, temp);
//            maxHeapifyDown(arr, max);
//        }
//    }
//
//    private void minHeapifyUp(ArrayList<Integer> arr, int pos) {
//        if(pos == 0) return;
//        int parent = (pos-1)/2;
//        if(arr.get(parent)>arr.get(pos)){
//            int temp = arr.get(parent);
//            arr.set(parent, arr.get(pos));
//            arr.set(pos, temp);
//            minHeapifyUp(arr, parent);
//        }
//    }
//
//    private void minHeapifyDown(ArrayList<Integer> arr, int pos) {
//        int parent = pos;
//        int child1 = pos*2+1;
//        int child2 = pos*2+2;
//        int min = parent;
//        if(child1<arr.size() &&  arr.get(child1)<arr.get(min)){
//            min = child1;
//        }
//        if(child2<arr.size() &&  arr.get(child2)<arr.get(min)){
//            min = child2;
//        }
//        if(min!=parent && arr.get(min)<arr.get(parent)){
//            int temp = arr.get(parent);
//            arr.set(parent, arr.get(min));
//            arr.set(min, temp);
//            minHeapifyDown(arr, min);
//        }
//    }
//
//    public double findMedian() {
//        if(leftCounter>rightCounter){
//            return arrLeft.getFirst();
//        } else if(leftCounter == rightCounter){
//            return (arrLeft.getFirst()+arrRight.getFirst())/(double)2;
//        }
//        return -1;
//    }

    PriorityQueue<Integer> minRight = new PriorityQueue<>();
    PriorityQueue<Integer> maxLeft = new PriorityQueue<>((a,b) -> b-a);

    public void addNum(int num) {
        if(maxLeft.isEmpty()){
            maxLeft.add(num);
            return;
        }
        if(num<=maxLeft.peek()){
            maxLeft.add(num);
            if(maxLeft.size()>minRight.size()+1){
                minRight.add(maxLeft.poll());
            }
        }
        else {
            minRight.add(num);
            if(minRight.size()>maxLeft.size()){
                maxLeft.add(minRight.poll());
            }
        }
    }

    public double findMedian() {
        if((minRight.size()+maxLeft.size())%2 == 0){
            return (minRight.peek()+maxLeft.peek())/(double)2;
        } else
            return maxLeft.peek();
    }
}
