package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    GraphNode[] copyArr = new GraphNode[101];
    boolean[] visited = new boolean[101];

    public static void main(String args[]){
        GraphNode node1 = new GraphNode();
        node1.val = 1;
        node1.neighbors = new ArrayList<>();

        GraphNode node2 = new GraphNode();
        node2.val = 2;
        node2.neighbors = new ArrayList<>();

        GraphNode node3 = new GraphNode();
        node3.val = 3;
        node3.neighbors = new ArrayList<>();

        GraphNode node4 = new GraphNode();
        node4.val = 4;
        node4.neighbors = new ArrayList<>();

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph c = new CloneGraph();
        c.cloneGraph(node1);
    }

    public GraphNode cloneGraph(GraphNode node){
        if(node == null) return null;
        if(visited[node.val]) return copyArr[node.val];
        visited[node.val] = true;
        GraphNode newNode = new GraphNode();
        copyArr[node.val] = newNode;
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        for(GraphNode g : node.neighbors){
            newNode.neighbors.add(cloneGraph(g));
        }
        return newNode;
    }

    static class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
    }
}
