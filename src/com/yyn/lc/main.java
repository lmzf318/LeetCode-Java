package com.yyn.lc;

import com.yyn.lc.array.*;
import com.yyn.lc.bit.Num1Bits;

/**
 * Created by jiy on 5/10/16.
 *
 * Test solutions.
 */
public class main {
    public final static String TAG = "com.yyn.lc.main";

    public static void main(String[] args) {
        Num1Bits num1Bits = new Num1Bits();
        Util.logD(TAG, "hammingWeight: " + num1Bits.hammingWeight(8));
    }
}
