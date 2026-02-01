package leetcode;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        ValidParanthesis v= new ValidParanthesis();
        v.isValid("[{()}][");
    }
//    public static boolean isValid(String s) {
//        boolean isValid = true;
//        Stack<Character> stack = new Stack<>();
//        for(char c :s.toCharArray()){
//            if(c=='(' || c=='{' || c=='[') {
//                stack.push(c);
//            } else if(stack.isEmpty())
//                isValid = false;
//            else if (c==')') {
//                char c1 = stack.pop();
//                if(c1!='(')
//                    isValid = false;
//            }else if (c=='}') {
//                char c1 = stack.pop();
//                if(c1!='{')
//                    isValid = false;
//            }else if (c==']') {
//                char c1 = stack.pop();
//                if(c1!='[')
//                    isValid = false;
//            }
//        }
//        if(!stack.isEmpty())
//            isValid = false;
//
//        return isValid;
//    }

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for(char c : ch){
            if(c=='[') stack.add(']');
            else if(c=='{') stack.add('}');
            else if(c=='(') stack.add(')');
            else
                if(stack.empty() || stack.pop()!=c) {
                    isValid = false;
                    break;
                }

        }
        return isValid && stack.empty();
    }
}
