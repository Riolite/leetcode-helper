package com.riolite.leetcode.hard;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int positiveCount = countPositive(nums);
        int positiveMin = findPositiveMin(nums);
        int missingPositive = 1;

        if (positiveMin != 1) return missingPositive;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - positiveMin;
            if (index > 0 && index < nums.length && nums[index] > 0) nums[index] = -nums[index];
        }

        missingPositive = positiveCount+1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > 0) {
                missingPositive = i + 1;
                break;
            }
        }
        return missingPositive;
    }

    private int findPositiveMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
            if (nums[i] < min && nums[i] > 0) min = nums[i];
        }
        return min;
    }

    private int countPositive(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Missing Positive: " + new FirstMissingPositive().firstMissingPositive(new int[]{1,2,6,3,5,4}));
        System.out.println("Missing Positive: " + new FirstMissingPositive().firstMissingPositive(new int[]{0,-1,3,1}));
        System.out.println("Missing Positive: " + new FirstMissingPositive().firstMissingPositive(new int[]{0,2,2,1,1}));
        System.out.println("Missing Positive: " + new FirstMissingPositive().firstMissingPositive(new int[]{0,2,2,4,0,1,0,1,3}));
    }
}
