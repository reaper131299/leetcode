package leetcode.medium;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public static void main(String args[]) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                merged.add(merge(l1, l2));
            }

            lists = merged.toArray(ListNode[]::new);
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode mainNode = new ListNode();
        ListNode ogMainNode = mainNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mainNode.next = l1;
                l1 = l1.next;
            } else {
                mainNode.next = l2;
                l2 = l2.next;
            }
            mainNode = mainNode.next;
            mainNode.next = null;
        }

        if (l1 == null) {
            mainNode.next = l2;
        } else {
            mainNode.next = l1;
        }
        return ogMainNode.next;
    }
}
