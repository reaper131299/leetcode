package leetcode.medium;

import leetcode.easy.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    TreeNode found = null;

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);

        t1.left = t2;

        LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();
        l.lowestCommonAncestor(t1, t2, t1);

    }

    private TreeNode callerMethod(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        TreeNode left = callerMethod(root.left, p, q);
        TreeNode right = callerMethod(root.right, p, q);

        if((left == p || left == q) && (right == p || right == q) ) {
            found = root;
            return root;
        } else if(root == p || root == q) {
            if((root == p && (left == q || right == q)) || (root == q && (left == p || right == p)))
                found = root;
            return root;
        } else if(left == p || left == q) {
            return left;
        } else if(right == p || right == q){
            return right;
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        callerMethod(root, p, q);
        return found;
    }
}
