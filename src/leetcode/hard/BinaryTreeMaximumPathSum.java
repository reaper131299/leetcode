package leetcode.hard;

import leetcode.easy.TreeNode;

public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(100);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(-15);
        TreeNode t5 = new TreeNode(-7);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        b.maxPathSum(t1);

    }

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return res;
    }

    public int maxPathSumUtil(TreeNode root) {
        if(root == null) return 0;

        int leftMax = maxPathSumUtil(root.left);
        int rightMax = maxPathSumUtil(root.right);

        int maxLeftPathAndRoot = root.val+leftMax;
        int maxRightPathAndRoot = root.val+rightMax;
        //Max between leftpath+root and rightpath+root
        int maxPath = Math.max(maxLeftPathAndRoot, maxRightPathAndRoot);

        //max between leftpath+rightpath+root and maxbetween left and right
        int maxBothPathAndMaxPath = Math.max(maxPath, root.val+leftMax+rightMax);

        //max between all the paths and just root.
        int maxBothPath  = Math.max(maxBothPathAndMaxPath, root.val);
        res = Math.max(res, maxBothPath);

        return Math.max(root.val, Math.max(maxLeftPathAndRoot, maxRightPathAndRoot));
    }
}
