package com.yyn.lc.bit;

/**
 * Created by jiy on 5/25/16.
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * Do it in-place with O(1) extra memory and O(n) time.
 */
public class MissingNumber {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        int m = 0;
        for (int index1 = 0; index1 <= nums.length; index1++) {
            m = m ^ index1;
        }

        for (int index2 = 0; index2 < nums.length; index2++) {
            m = m ^ nums[index2];
        }

        return m;
    }
}
