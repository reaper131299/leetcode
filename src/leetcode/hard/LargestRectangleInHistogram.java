package leetcode.hard;

public class LargestRectangleInHistogram {

    public static void main(String args[]){
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        l.largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6});

    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[][] stack = new int[heights.length][2];
        int top = -1;

        for(int i = 0;i<heights.length;i++){
            if(top == -1 || heights[i]>=stack[top][1]){
                top++;
                stack[top][0] = i;
                stack[top][1] = heights[i];
            } else if (heights[i]<stack[top][1]) {
                int index = -1;
                while(top!=-1 && stack[top][1]>heights[i]){
                    index = stack[top][0];
                    int height = stack[top][1];
                    res = Math.max(res, height * (i - index));
                    top--;
                }
                top++;
                stack[top][0] = index;
                stack[top][1] = heights[i];
            }
        }

        int lastEntryIndex = heights.length-1;
        while(top != -1){
            res = Math.max(res, stack[top][1]*(lastEntryIndex-stack[top][0]+1));
            top--;
        }
        return res;
    }
}
