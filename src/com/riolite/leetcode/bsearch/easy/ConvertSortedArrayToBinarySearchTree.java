package com.riolite.leetcode.bsearch.easy;


import com.riolite.leetcode.model.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length < 1){
            return null;
        }
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int middleValue = nums[nums.length/2];
        int[] lSubArray = Arrays.stream(nums).limit(nums.length/2).toArray();
        TreeNode left = sortedArrayToBST(lSubArray);
        int[] rSubArray = Arrays.stream(nums).skip((nums.length+2) /2).toArray();
        TreeNode right = sortedArrayToBST(rSubArray);
        return new TreeNode(middleValue,left,right);
    }

    public static TreeNode sortedArrayToBSTOpt(int[] nums, int start, int end) {
        int length = end - start + 1;
        int index = start + ((end-start)/2);
        if(length < 1){
            return null;
        }
        if(length == 1) {
            return new TreeNode(nums[index]);
        }

        int middleValue = nums[index];
        TreeNode left = sortedArrayToBSTOpt(nums, start, index-1);
        TreeNode right = sortedArrayToBSTOpt(nums, index+1, end);
        return new TreeNode(middleValue,left,right);
    }
}
