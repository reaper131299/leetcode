package leetcode.medium;

public class DailyTemperatures {

    public static void main(String args[]) {
        DailyTemperatures d = new DailyTemperatures();
        d.dailyTemperatures(new int[]{73,74,75,71,69,72,70,76,73});
    }

//    public int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> stack = new Stack<>();
//        int[] res = new int[temperatures.length];
//        for(int i = 0; i<temperatures.length; i++) {
//            if(!stack.isEmpty() && temperatures[i]>temperatures[i-1]){
//                while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
//                    int idx = stack.pop();
//                    res[idx] = i-idx;
//                }
//            }
//            stack.push(i);
//        }
//        return res;
//    }


    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int[] res = new int[n];
        int top = -1;


        for(int i = 0; i<n; i++) {
            if(top!=-1 && temperatures[i]>temperatures[i-1]){
                while(top!=-1 && temperatures[stack[top]]<temperatures[i]){
                    int idx = stack[top--];
                    res[idx] = i-idx;
                }
            }
            stack[++top] = i;
        }
        return res;
    }
}
