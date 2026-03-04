package leetcode.hard;

import leetcode.easy.ListNode;

public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
        r.reverseKGroup(a1, 4);
    }


//    public ListNode reverseKGroup(ListNode head, int k) {
//        ArrayList<ListNode> lists = new ArrayList<>();
//        int group = 0;
//        ListNode groupInit = null;
//        while (head != null) {
//            group++;
//            ListNode nextHead = head.next;
//            if (groupInit == null) {
//                groupInit = head;
//            }
//            if (group == k) {
//                lists.add(groupInit);
//                head.next = null;
//                head = nextHead;
//                groupInit = null;
//                group = 0;
//                continue;
//            }
//            head = head.next;
//        }
//
//        lists.replaceAll(this::reverse);
//
//        if (lists.isEmpty()) {
//            return groupInit;
//        }
//
//        ListNode mergedList = lists.getFirst();
//        for (int i = 1; i < lists.size(); i++) {
//            while (mergedList.next != null) {
//                mergedList = mergedList.next;
//            }
//            mergedList.next = lists.get(i);
//        }
//
//        while (mergedList.next != null) {
//            mergedList = mergedList.next;
//        }
//
//        mergedList.next = groupInit;
//
//        return lists.getFirst();
//    }
//
//    private ListNode reverse(ListNode list) {
//        if (list == null || list.next == null) return list;
//        ListNode node = reverse(list.next);
//        list.next.next = list;
//        list.next = null;
//        return node;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        int group = 0;
        ListNode headPrev = dummyNode;
        ListNode tail = head;
        while (head != null && tail !=null) {
            group++;
            if (group == k) {
                ListNode tailNext = tail.next;
                headPrev.next = reverse(head, tail);
                head.next = tailNext;
                headPrev = head;
                head = tailNext;
                tail = tailNext;
                group = 0;
                continue;
            }
            tail = tail.next;
        }

        return dummyNode.next;
    }

    private ListNode reverse(ListNode list, ListNode tail) {
        if (list == tail) return list;
        ListNode node = reverse(list.next, tail);
        list.next.next = list;
        list.next = null;
        return node;
    }
}
