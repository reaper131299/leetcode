package leetcode.hard;

import leetcode.easy.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBinaryTree {

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

        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        SerializeAndDeserializeBinaryTree s2 = new SerializeAndDeserializeBinaryTree();
        s2.deserialize(s.serialize(t1));

    }

    //instead if array directly use string builder for better performance
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue= new LinkedList<>();

        if(root == null) return "n";

        queue.add(root);
        StringBuilder builderSb = new StringBuilder();

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while (queueSize>0){
                TreeNode node = queue.poll();
                if(node!=null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    builderSb.append(node.val).append(",");
                } else
                    builderSb.append("n").append(",");
                queueSize--;
            }
        }

        //remove one , from last
        builderSb.delete(builderSb.length()-1, builderSb.length());

        return builderSb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("n".equals(data)) return null;

        String[] arr = data.split(",");
        LinkedList<TreeNode> queue= new LinkedList<>();

        int left = 1;
        int right = 2;
        TreeNode mainNode = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(mainNode);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"n".equals(arr[left])) {
                TreeNode nodeLeft = new TreeNode(Integer.parseInt(arr[left]));
                node.left = nodeLeft;
                queue.add(nodeLeft);
            }

            if(!"n".equals(arr[right])) {
                TreeNode nodeRight = new TreeNode(Integer.parseInt(arr[right]));
                node.right = nodeRight;
                queue.add(nodeRight);
            }

            left = left + 2;
            right = right + 2;
        }

        return mainNode;
    }
}
