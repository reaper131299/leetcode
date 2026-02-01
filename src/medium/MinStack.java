package medium;

import java.util.ArrayList;

public class MinStack {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.pop();
        minStack.top();
        minStack.pop();
        minStack.push(-3);
        minStack.getMin();
    }

    int stackHeadPointer = -1;
    ArrayList<Integer> stackArr = new ArrayList<>();
    int minHeadPointer = -1;
    ArrayList<Integer> minArr = new ArrayList<>();
    public MinStack() {

    }

    public void push(int val) {
        stackHeadPointer++;
        stackArr.add(val);
        if(minHeadPointer==-1){
            minHeadPointer++;
            minArr.add(val);
        } else {
            if(val<=minArr.get(minHeadPointer)){
                minHeadPointer++;
                minArr.add(val);
            }
        }

    }

    public void pop() {
        if(stackArr.get(stackHeadPointer).equals(minArr.get(minHeadPointer))){
            minArr.remove(minHeadPointer);
            minHeadPointer--;
        }
        stackArr.remove(stackHeadPointer);
        stackHeadPointer--;

    }

    public int top() {
        return stackArr.get(stackHeadPointer);

    }

    public int getMin() {
        return minArr.get(minHeadPointer);
    }
}
