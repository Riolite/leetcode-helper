package com.riolite.leetcode.medium;

import com.riolite.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelI = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            if(levelI % 2 == 0){
                reverseList(level);
            }
            levels.add(level);
            levelI++;
        }
        return levels;
    }
    private void reverseList(List<Integer> list){
        for (int i = 0; i < list.size()/2; i++) {
            Integer a = list.get(i);
            Integer b = list.get(list.size()-1-i);
            list.set(i,b);
            list.set(list.size()-1-i,a);
        }
    }
}
