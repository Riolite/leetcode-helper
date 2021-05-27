package com.riolite.leetcode.medium;

import com.riolite.leetcode.model.ListNode;
import com.riolite.leetcode.util.Utilities;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode hare = head, tortoise = head;
        do {
            if (hare == null || hare.next == null) return null;
            hare = hare.next.next;
            tortoise = tortoise.next;
        } while (hare != tortoise);

        hare = head;

        while (hare != tortoise) {
            hare = hare.next;
            tortoise = tortoise.next;
        }
        return hare;
    }

    public static void main(String[] args) {
        System.out.println("Cycle starts at: " + new LinkedListCycleII().detectCycle(Utilities
                .createLinkedList(new int[]{0,1,2,3,4,5,6})));
    }
}
