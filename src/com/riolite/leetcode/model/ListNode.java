package com.riolite.leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String print() {
        return val +" "+((next!=null)?next.print():"");
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ",next="+((next != null)?next.val:"null")+
                '}';
    }
}
