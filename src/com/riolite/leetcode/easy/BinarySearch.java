package com.riolite.leetcode.easy;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Index: " + new BinarySearch().search(new int[]{2, 5}, 0));
    }

    public int search(int[] nums, int target) {
        return _iterSearch(nums, target);
    }

    public int _search(int[] nums, int target, int startIndex, int endIndex) {
        int pivot = startIndex + (endIndex - startIndex) / 2;
        if (nums[pivot] == target) return pivot;
        if (endIndex <= startIndex) return -1;
        if (nums[pivot] < target) startIndex = pivot + 1;
        else endIndex = pivot - 1;
        return _search(nums, target, startIndex, endIndex);
    }

    public int _iterSearch(int[] nums, int target) {
        int startIndex = 0, endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int pivot = startIndex + (endIndex - startIndex) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] < target) startIndex = pivot + 1;
            else endIndex = pivot - 1;
        }
        return -1;
    }
}
