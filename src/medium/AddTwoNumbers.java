package medium;

import leetcode.ListNode;

public class AddTwoNumbers {

    public static void main(String args[]) {

        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);

        l21.next = l22;
        l22.next = l23;

        AddTwoNumbers a = new AddTwoNumbers();
        a.addTwoNumbers(l11, l21);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode ogListNode = listNode;
        int carry = 0;
        while(l1!=null && l2!=null){
            ListNode newListNode = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            listNode.next = newListNode;
            listNode = newListNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null) {
            while (l2 != null) {
                ListNode newListNode = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                listNode.next = newListNode;
                listNode = newListNode;
                l2 = l2.next;
            }
        }
        else {
            while (l1 != null) {
                ListNode newListNode = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                listNode.next = newListNode;
                listNode = newListNode;
                l1 = l1.next;
            }
        }

        if (carry!=0){
            listNode.next = new ListNode((carry) % 10);
        }

        return ogListNode.next;
    }
}
