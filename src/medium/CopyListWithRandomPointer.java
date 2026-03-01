package medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String args[]) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);



        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyListWithRandomPointer c = new CopyListWithRandomPointer();
        c.copyRandomList(node1);

    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node ogHead = head;
        Node copyHead = new Node(0);
        Node ogCopyHead = copyHead;
        while (head!=null){
            Node copyNode = new Node(head.val);
            copyHead.next = copyNode;
            nodeMap.put(head, copyNode);
            head = head.next;
            copyHead = copyHead.next;
        }

        head = ogHead;

        while (head!=null){
            nodeMap.get(head).random = nodeMap.get(head.random);
            head = head.next;
        }

        return ogCopyHead.next;
    }
}
