package com.yyn.lc.array;

/**
 * Created by jiy on 5/14/16.
 * <p>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space (size that is greater or equal to m + n) to
 * hold additional elements from B.The number of elements initialized in A and B are m and n respectively.
 */
public class MergeArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int sum = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;

        // index -- every round
        // indexLarger --
        for (int index = sum; index >= 0; index--) {
            if (indexA >= 0 && indexB >= 0) {
                if (A[indexA] >= B[indexB]) {
                    A[index] = A[indexA--];
                } else {
                    A[index] = B[indexB--];
                }
            } else if (indexA < 0) {
                A[index] = B[indexB--];
            } else if (indexB < 0) {
                A[index] = A[indexA--];
            }
        }
    }
}
