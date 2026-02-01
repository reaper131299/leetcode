package leetcode;

public class InvertBinaryTree {
    public static void main(String[] args) {
//        invertTree("rat","car");

    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode right = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = right;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
