package leetcode.medium;

import leetcode.easy.ListNode;

public class RemoveNthNodeFromEndOfList {
    int count;
    int elementToBeRemoved;

    public static void main(String args[]) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(4);
//        ListNode a5 = new ListNode(5);
        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;

        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        r.removeNthFromEnd(a1, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;

        elementToBeRemoved = n;
        ListNode l = new ListNode();
        l.next = head;
        remove(l);
        return l.next;
    }

    public ListNode remove(ListNode head){
        if(head == null) return null;
        count++;
        ListNode headNext = remove(head.next);
        elementToBeRemoved--;
        if(elementToBeRemoved == 0){
            return headNext;
        } else if(elementToBeRemoved == -1) {
            head.next = headNext;
        }
        return head;
    }
}
