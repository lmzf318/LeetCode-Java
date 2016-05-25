package com.yyn.lc.array;

/**
 * Created by jiy on 5/23/16.
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class FindInsertPosition {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
