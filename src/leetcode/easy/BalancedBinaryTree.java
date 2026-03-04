package leetcode.easy;

public class BalancedBinaryTree {
    static boolean isBalanced = true;
    public static void main(String[] args) {

    }

//    public static boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        int rightDepth = maxDepth(root.right);
//        int leftDepth = maxDepth(root.left);
//
//        if(Math.abs(rightDepth-leftDepth)>1){
//            return false;
//        }
//        return isBalanced(root.right) && isBalanced(root.left);
//    }
//
//    public static int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
//    }

    public static boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    public static int dfs(TreeNode root) {
        if(root == null) return 0;
        int rightDfs = dfs(root.right);
        int leftDfs = dfs(root.left);

        if(Math.abs(rightDfs-leftDfs)>1){
            isBalanced = false;
        }

        return 1 + Math.max(rightDfs,leftDfs);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}





















