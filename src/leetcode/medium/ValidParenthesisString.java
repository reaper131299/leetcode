package leetcode.medium;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String args[]){
        ValidParenthesisString v = new ValidParenthesisString();
        v.checkValidString("(*)");
    }

//    public boolean checkValidString(String s) {
//        return checkValidStringUtil(s, 0, 0);
//    }
//
//    public boolean checkValidStringUtil(String s, int idx, int count) {
//
//        for(int i = idx; i<s.length(); i++){
//            if(count<0) return false;
//            if(s.charAt(i) == '(') count++;
//            else if(s.charAt(i) == ')') count--;
//            else {
//                return checkValidStringUtil(s, i+1, count+1) || checkValidStringUtil(s, i+1, count-1) || checkValidStringUtil(s, i+1, count);
//            }
//        }
//        return count == 0;
//    }

//    public boolean checkValidString(String s) {
//        int leftMin = 0;
//        int leftMax = 0;
//
//        for(char c : s.toCharArray()){
//            if(c == '(') {
//                leftMin++;
//                leftMax++;
//            } else if(c == ')') {
//                leftMin--;
//                leftMax--;
//            } else {
//                leftMin--;
//                leftMax++;
//            }
//
//            if(leftMax < 0) return false;
//            if(leftMin < 0) leftMin = 0;
//        }
//
//        return leftMin == 0;
//    }

    public boolean checkValidString(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> starStk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stk.add(i);
            else if(c == '*') starStk.add(i);
            else
                if(!stk.isEmpty()) stk.pop();
                else if (!starStk.isEmpty()) starStk.pop();
                else return false;
        }

        while(!stk.isEmpty() && !starStk.empty()){
            if(stk.peek() > starStk.peek()) return false;
            stk.pop();
            starStk.pop();
        }

        return stk.isEmpty();
    }
}
