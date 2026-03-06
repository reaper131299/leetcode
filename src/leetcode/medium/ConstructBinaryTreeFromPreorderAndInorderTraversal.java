package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = 0;
    int[] preorder;

    public static void main(String args[]) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        c.buildTree(new int[]{3, 9, 10, 20, 15, 7}, new int[]{9, 10, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        if (preorder.length == 0 || inorder.length == 0) return null;

        return buildTreeUtil(0, inorder.length-1);
    }

//    public TreeNode buildTreeUtil(int[] preorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
//
//        if((preOrderLeft>preOrderRight) || (inOrderLeft>inOrderRight)) return null;
//
//        TreeNode node = new TreeNode(preorder[preOrderLeft]);
//        int idx = map.get(node.val);
//
//        node.left = buildTreeUtil(preorder, preOrderLeft+1, preOrderLeft+(idx-inOrderLeft), inOrderLeft, idx-1);
//        node.right = buildTreeUtil(preorder, preOrderLeft+(idx-inOrderLeft)+1, preOrderRight, idx+1, inOrderRight);
//
//        return node;
//    }

    public TreeNode buildTreeUtil(int left, int right) {

        if (left>right) return null;

        TreeNode node = new TreeNode(preorder[n]);
        n++;
        int idx = map.get(node.val);

        node.left = buildTreeUtil(left, idx-1);
        node.right = buildTreeUtil(idx+1, right);

        return node;
    }
}
