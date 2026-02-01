package leetcode;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
//        isAnagram("rat","car");
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
