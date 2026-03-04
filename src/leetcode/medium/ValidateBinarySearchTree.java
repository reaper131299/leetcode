package leetcode.medium;

import leetcode.easy.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String args[]){

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTUtil(root.left, Long.MIN_VALUE, root.val) && isValidBSTUtil(root.right, root.val, Long.MAX_VALUE);
    }


    public boolean isValidBSTUtil(TreeNode root, long leftBoundary, long rightBoundary) {
        if(root == null) return true;
        boolean isNodeValid = leftBoundary<root.val && root.val<rightBoundary;
        return isNodeValid && isValidBSTUtil(root.left, leftBoundary, root.val) && isValidBSTUtil(root.right, root.val, rightBoundary);
    }
}
