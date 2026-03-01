package medium;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {

    public static void main(String args[]){

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            int rightMost = 0;
            for(int i = 0; i<size; i++){
                TreeNode node = queue.pollFirst();
                rightMost = node.val;

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left !=null) queue.add(left);
                if (right !=null) queue.add(right);
            }
            finalList.add(rightMost);
        }
        return finalList;
    }
}
