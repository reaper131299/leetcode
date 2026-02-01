package leetcode;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        mergeTwoLists(a1, b1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode initNode = new ListNode();
        ListNode currNode = initNode;
        while (list1 !=null && list2 !=null){
            if(list1.val>list2.val){
                currNode.next = list2;
                list2 = list2.next;
                currNode.next.next = null;
            } else {
                currNode.next = list1;
                list1 = list1.next;
                currNode.next.next = null;
            }
//            else if(list1.val==list2.val){
//                currNode.next = list1;
//                currNode = currNode.next;
//                list1 = list1.next;
//                currNode.next = null;
//
//                currNode.next = list2;
//                list2 = list2.next;
//                currNode.next.next =null;
//            }
            currNode = currNode.next;
        }

        if(list1 ==null)
            currNode.next = list2;
        else if (list2 == null)
            currNode.next = list1;

        return initNode.next;
    }
}
