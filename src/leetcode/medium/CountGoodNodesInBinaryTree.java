package leetcode.medium;

import leetcode.easy.TreeNode;

public class CountGoodNodesInBinaryTree {
    int count = 0;

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;

        CountGoodNodesInBinaryTree c = new CountGoodNodesInBinaryTree();
        c.goodNodes(t1);

    }

    public int goodNodes(TreeNode root) {
        callerMethod(root, Integer.MIN_VALUE);
        return count;
    }

    private void callerMethod(TreeNode root, int prevMax) {
        if(root == null) return;
        if(prevMax<= root.val) {
            count++;
            prevMax = root.val;
        }

        callerMethod(root.left, prevMax);
        callerMethod(root.right, prevMax);
    }
}
