package com.riolite.leetcode.medium;

import com.riolite.leetcode.model.ListNode;
import com.riolite.leetcode.util.Utilities;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddHead = head.next, currentNode = head;
        while (currentNode.next != null) {
            ListNode oddNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            if(currentNode.next != null) oddNode.next = currentNode.next.next;
            else oddNode.next = null;
            if (currentNode.next != null)
                currentNode = currentNode.next;
        }
        currentNode.next = oddHead;
        return head;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Output: " + new OddEvenLinkedList().oddEvenList(Utilities
                .createLinkedList(new int[]{1, 2, 3, 4, 5})).print());
    }
}
