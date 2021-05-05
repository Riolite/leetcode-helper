package com.riolite.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Stream;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        return (nums.length * (nums.length + 1)) / 2
                -
                Arrays.stream(nums)
                        .sum();
    }

    public static void main(String[] args) {
        System.out.println("Missing number is: " +
                missingNumber(
                        Stream.of(0, 1, 2, 9, 4, 5, 6, 7, 8)
                                .mapToInt(i -> i)
                                .toArray()
                )
        );
    }
}
