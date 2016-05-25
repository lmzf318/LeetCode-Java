package com.yyn.lc.array;

/**
 * Created by jiy on 5/22/16.
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * Time complexity <= O(log n).
 */
public class SearchARange {
    /**
     * @param A      : an integer sorted array
     * @param target :  an integer to be inserted
     *               return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[]{-1, -1};
        int start = searchLow(0, A.length - 1, target, A);
        if (start < A.length && A[start] == target) {
            ret[0] = start;
            ret[1] = searchHigh(start, A.length - 1, target, A);
        } else {
            ret[0] = ret[1] = -1;
        }

        return ret;
    }

    private int searchLow(int start, int end, int target, int[] A) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int searchHigh(int start, int end, int target, int[] A) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
