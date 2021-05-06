package com.riolite.leetcode.easy;

//https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int val = n & (0x00000001<<i);
            if(i == 31 && val != 0){// handling unsigned int shifting
                val >>= 1;
                val &= 0x40000000;
                result |= val>>30;
            }else {
                result |= (((i < 16) ? val << (31 - 2*i) : val >> (2*i - 31)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Val: "+new ReverseBits().reverseBits(0xFFFFFFFD));
    }
}
