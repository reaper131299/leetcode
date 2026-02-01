package leetcode;

public class SameTree {
    public static void main(String[] args) {
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
