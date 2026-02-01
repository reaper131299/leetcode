package leetcode;

public class IsSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        // subRoot = [4,1,2] (left to right)
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        IsSubTree isSubTree = new IsSubTree();
        isSubTree.isSubtree(root, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;
        if(isSameTree(root,subRoot)) return true;
        return isSubtree(root.right,subRoot) || isSubtree(root.left,subRoot) ;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean b = areNodeEqual(p,q);
        if(p != null && q!=null)
            return b && (isSameTree(p.right, q.right) && isSameTree(p.left, q.left));
        else return b;
    }

    public boolean areNodeEqual(TreeNode p, TreeNode q){
        if(p == null && q==null)
            return true;
        else if(p == null || q == null)
            return false;
        else return p.val == q.val;
    }
}
