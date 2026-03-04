package leetcode.medium;

public class EvaluateReversePolishNotation {


    public static void main (String args[]){
        System.out.println(6/-132);
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    //this is the only sution the time can be reduced if you use array of ints where size of aray can be number of tokens and switch case
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//
//        for(String s : tokens){
//            if("+".equals(s) || "*".equals(s) || "-".equals(s) || "/".equals(s)){
//                Integer o2 = stack.pop();
//                Integer o1 = stack.pop();
//                if("+".equals(s))
//                    stack.push(o1+o2);
//                else if("*".equals(s))
//                    stack.push(o1*o2);
//                else if("-".equals(s))
//                    stack.push(o1-o2);
//                else stack.push(o1/o2);
//            } else {
//                stack.push(Integer.valueOf(s));
//            }
//        }
//        return stack.pop();
//    }

    public int evalRPN(String[] tokens) {
        int top = -1;
        int[] arr = new int[tokens.length];
        for(String s : tokens ){
            switch (s) {
                case "+": arr[--top] = arr[top]+arr[top+1]; break;
                case "*": arr[--top] = arr[top]*arr[top+1]; break;
                case "-": arr[--top] = arr[top]-arr[top+1]; break;
                case "/": arr[--top] = arr[top]/arr[top+1]; break;
                default:arr[++top] = Integer.parseInt(s); break;
            }
        }
        return arr[top];
    }
}
