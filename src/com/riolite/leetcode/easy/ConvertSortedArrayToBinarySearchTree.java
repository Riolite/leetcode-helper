package com.riolite.leetcode.easy;


import com.riolite.leetcode.model.TreeNode;

import java.util.Arrays;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {
    /*
    Simply put, this function finds the middle element of the array and splits
    it around the middle element into left and right subarrays. It then recursively calculates
     the middle element of each subarray.
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int middleValue = nums[nums.length / 2];
        int[] lSubArray = Arrays.stream(nums).limit(nums.length / 2).toArray();
        TreeNode left = sortedArrayToBST(lSubArray);
        int[] rSubArray = Arrays.stream(nums).skip((nums.length + 2) / 2).toArray();
        TreeNode right = sortedArrayToBST(rSubArray);
        return new TreeNode(middleValue, left, right);
    }

    /*
        A wrapper for _sortedArrayBSTOptimized(int[] nums, int start, int end).
    */
    public static TreeNode sortedArrayToBSTOptimized(int[] nums) {
        return _sortedArrayBSTOptimized(nums, 0, nums.length - 1);
    }

    /*
        An optimized version of sortedArrayToBST(int[] nums) where no new arrays are constructed.
    */
    public static TreeNode _sortedArrayBSTOptimized(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length < 1) {
            return null;
        }
        int index = start + ((end - start) / 2);
        if (length == 1) {
            return new TreeNode(nums[index]);
        }
        int middleValue = nums[index];
        TreeNode left = _sortedArrayBSTOptimized(nums, start, index - 1);
        TreeNode right = _sortedArrayBSTOptimized(nums, index + 1, end);
        return new TreeNode(middleValue, left, right);
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-1, 0, 1, 2});
        root =sortedArrayToBSTOptimized(new int[]{-10, -3, 0, 5, 9});
    }
}
