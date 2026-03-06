package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInABST {
    ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String args[]){

    }

//    public int kthSmallest(TreeNode root, int k) {
//        kthSmallestUtil(root);
//        return arr.get(k-1);
//    }
//
//    public void kthSmallestUtil(TreeNode root) {
//        if(root == null) return;
//        kthSmallestUtil(root.left);
//        arr.add(root.val);
//        kthSmallestUtil(root.right);
//    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        if(root!=null) stack.add(root);

        while (root !=null || !stack.empty()){
            while(root !=null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode n = stack.pop();
            count++;
            if(count == k) return n.val;
            root = n.right;
        }

        return -1;
    }
}
