package com.riolite.leetcode.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {binarySearchLeft(nums,target), binarySearchRight(nums,target)};
    }

    public int binarySearchLeft(int[] nums, int target){
        int startIndex = 0, endIndex = nums.length - 1;
        while(startIndex <= endIndex){
            int pivot = startIndex + (endIndex - startIndex) / 2;
            if(nums[pivot] == target){
                if(pivot - 1 < startIndex) return pivot;
                if(nums[pivot-1] != target)
                return pivot;
                else endIndex = pivot - 1;
            }
            if(nums[pivot] < target) startIndex = pivot + 1;
            else if(nums[pivot] > target) endIndex = pivot -1;
        }
        return -1;
    }

    public int binarySearchRight(int[] nums, int target){
        int startIndex = 0, endIndex = nums.length - 1;
        while(startIndex <= endIndex){
            int pivot = startIndex + (endIndex - startIndex) / 2;
            if(nums[pivot] == target){
                if(pivot + 1 > endIndex) return pivot;
                if(nums[pivot+1] != target)
                    return pivot;
                else startIndex = pivot + 1;
            }
            if(nums[pivot] < target) startIndex = pivot + 1;
            else if(nums[pivot] > target) endIndex = pivot -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Result: "+ Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(new int[]{0,1,2,3,4,5,8,8,8,9},8)));
    }
}
