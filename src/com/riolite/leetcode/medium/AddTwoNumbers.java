package com.riolite.leetcode.medium;

import com.riolite.leetcode.model.ListNode;
import com.riolite.leetcode.util.Utilities;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = new ListNode(0), currentNode = resultHead;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            l1 = (l1 != null)?l1.next:null;
            l2 = (l2 != null)?l2.next:null;
        }
        return resultHead.next;
    }

    public static void main(String[] args) {
        System.out.println("Sum: " + new AddTwoNumbers().addTwoNumbers(
                Utilities.createLinkedList(new int[]{1,0,2}),
                Utilities.createLinkedList(new int[]{1,0,2})
        ).print());
    }
}
