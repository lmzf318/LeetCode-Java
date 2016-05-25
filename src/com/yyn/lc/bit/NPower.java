package com.yyn.lc.bit;

/**
 * Created by jiy on 5/25/16.
 * 1. power of 2
 * Given an integer, write a function to determine if it is a power of two.
 */
public class NPower {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else {
            return ((n & (n - 1)) == 0);
        }
    }
}
