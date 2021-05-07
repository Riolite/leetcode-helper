package com.riolite.leetcode.easy;

import com.riolite.leetcode.model.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode n1 = head, n2 = head.next;
        while(!n1.equals(n2)){
            if(n2 == null || n2.next == null) return false;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(0)
                ,n2 = new ListNode(1, n3)
                ,n1 = new ListNode(2, n2);
        System.out.println("Has cycles: "+ new LinkedListCycle().hasCycle(n1));
    }
}
