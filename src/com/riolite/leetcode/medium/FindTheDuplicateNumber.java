package com.riolite.leetcode.medium;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println("Duplicate: " + new FindTheDuplicateNumber().findDuplicate(new int[]{1,2,3,4,5,6,7,3}));
    }
}
