package leetcode;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseList(n1);
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null) {
            stack.push(head);
            head = head.next;
            stack.peek().next = null;
        }

        ListNode list = null;
        ListNode curNode = null;
        while (!stack.isEmpty()){
            if(list == null) {
                list = stack.pop();
                curNode = list;
            }
            else {
                curNode.next = stack.pop();
                curNode = curNode.next;
            }

        }
        return list;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

