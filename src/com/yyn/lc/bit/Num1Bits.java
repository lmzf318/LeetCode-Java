package com.yyn.lc.bit;

import com.yyn.lc.Util;

/**
 * Created by jiy on 5/25/16.
 */
public class Num1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
