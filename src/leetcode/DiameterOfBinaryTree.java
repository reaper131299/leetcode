//package leetcode;
//
//public class DiameterOfBinaryTree {
//
//    public static void main(String[] args) {
////        isAnagram("rat","car");
//    }
//
//    //brute force O(N^2)
//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//        int leftdDepth = this.maxDepth(root.left);
//        int rightDepth = this.maxDepth(root.right);
//        return Math.max(leftdDepth+rightDepth, Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
//    }
//
//    public static int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
//    }
//
//    //optimized O(log(n))
//    int result = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        maxDepth(root);
//        return result;
//    }
//
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        int leftDepth = this.maxDepth(root.left);
//        int rightDepth = this.maxDepth(root.right);
//        result = Math.max(result, leftDepth+rightDepth);
//        return 1 + Math.max(leftDepth ,rightDepth);
//    }
//}
