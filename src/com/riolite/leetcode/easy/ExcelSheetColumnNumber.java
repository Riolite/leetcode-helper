package com.riolite.leetcode.easy;

//https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            sum += (columnTitle.charAt(columnTitle.length() - 1 - i) - 64) * (int) Math.pow(26,i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Column Number: " + new ExcelSheetColumnNumber().titleToNumber("FXSHRXW"));
    }
}
