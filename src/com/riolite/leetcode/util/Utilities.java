package com.riolite.leetcode.util;

import com.riolite.leetcode.model.ListNode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utilities {
    public static ListNode createLinkedList(int[] values){
        Map<Integer,ListNode> nodesMap = Arrays.stream(values)
                .mapToObj(ListNode::new)
                .collect(Collectors.toMap(node -> node.val, Function.identity(),(node1,node2) -> node1));

        ListNode start = nodesMap.get(values[0]);
        ListNode currentNode = start;
        for (int i = 1; i < values.length; i++) {
            if(currentNode.next != null) break;
            currentNode.next = nodesMap.get(values[i]);
            currentNode = currentNode.next;
        }
        return start;
    }


}
