package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
//    List<List<Integer>> finalList;

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        BinaryTreeLevelOrderTraversal b= new BinaryTreeLevelOrderTraversal();
        b.levelOrder(t1);

    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        finalList = new ArrayList<>();
//        traverse(root, 1);
//        return finalList;
//    }
//
//    public void traverse(TreeNode root, int level){
//        if(root == null){
//            return;
//        }
//        if(level>finalList.size()) {
//            finalList.add(new ArrayList<>());
//        }
//        finalList.get(level-1).add(root.val);
//
//        traverse(root.left, level+1);
//        traverse(root.right, level+1);
//    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.pollFirst();
                curr.add(node.val);

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left !=null) queue.add(left);
                if (right !=null) queue.add(right);
            }
            finalList.add(curr);
        }
        return finalList;
    }
}
