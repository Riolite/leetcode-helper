package com.riolite.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    Set<Integer> results = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }else if (results.contains(n)){
            return false;
        }else{
            results.add(n);
            return isHappy(calculateSumOfSquaredDigits(n));
        }
    }

    private int calculateSumOfSquaredDigits(int n){
        int unitDigit, sum = 0;
        while(n > 0){
                unitDigit = n % 10;
                sum += unitDigit*unitDigit;
                n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Is Happy: " + new HappyNumber().isHappy(10));
    }
}
