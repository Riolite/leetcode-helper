package com.riolite.leetcode;

import com.riolite.leetcode.bsearch.easy.ConvertSortedArrayToBinarySearchTree;
import com.riolite.leetcode.model.TreeNode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TreeNode root = ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-1,0,1,2});
        System.out.println("nums=> "+ Arrays.toString(new int[]{-10,-3,0,5,9}));
        TreeNode root1 = ConvertSortedArrayToBinarySearchTree.sortedArrayToBSTOpt(new int[]{-10,-3,0,5,9}, 0, 4);
        System.out.println();
    }
}
