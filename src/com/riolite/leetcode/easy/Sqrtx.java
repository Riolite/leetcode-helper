package com.riolite.leetcode.easy;

//https://leetcode.com/problems/sqrtx/
public class Sqrtx {
    public int mySqrt(int x) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            long square = pivot * ((long) pivot);
            if (square < x) {
                if ((pivot + 1) * ((long) pivot + 1) > x) return pivot;
                else left = pivot + 1;
            } else if (square > x) {
                if ((pivot - 1) * ((long) pivot - 1) < x) return pivot - 1;
                else right = pivot - 1;
            } else {
                return pivot;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("Sqrt: " + new Sqrtx().mySqrt(8));
    }
}
