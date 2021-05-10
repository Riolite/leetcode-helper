package com.riolite.leetcode.medium;

import com.riolite.leetcode.model.TreeNode;

import java.util.LinkedList;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {

    /* Iterative inorder traversal approach: Iteratively  do in order traversal. The smallest element in BST is the
    * leaf at the left.*/
    public int inorderIter(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }

    /* Recursive inorder traversal approach: doing inorder traversal of a BST returns them in ascending order.
    * All that is left is to pick the kth element from the sorted array.*/
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root)[k-1];
    }

    private int[] inorder(TreeNode root) {
        if (root == null) return new int[0];
        int[] left = inorder(root.left);
        int[] right = inorder(root.right);
        int[] current = new int[left.length + right.length + 1];
        if (left.length > 0)
            System.arraycopy(left, 0, current, 0, left.length);
        current[left.length] = root.val;
        if (right.length > 0)
            System.arraycopy(right, 0, current, left.length + 1, right.length);
        return current;
    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, null, n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n1, n4);

        System.out.println("Kth Smallest: " + new KthSmallestElementInBST().inorderIter(n3,2));
    }
}
