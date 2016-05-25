package com.yyn.lc.array;

/**
 * Created by Jimi on 5/17/2016.
 * <p>
 * 1.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * 2.
 * Elements in the array may be duplicate
 */
public class MinimumInSorted {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return num[0];
        } else if (num.length == 2) {
            return num[0] > num[1] ? num[1] : num[0];
        } else {
            // num[start] < num[mid] means minimum is in mid to end
            int start = 0;
            int end = num.length - 1;
            while (start < end - 1) {
                if (num[end] > num[start]) {
                    return num[start];
                } else {
                    // TODO
                    int mid = start + (end - start)/2;
                    if (num[mid] > num[start]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }

            return num[start] < num[end] ? num[start] : num[end];
        }
    }

    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMinII(int[] num) {
        if (num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return num[0];
        } else if (num.length == 2) {
            return num[0] > num[1] ? num[1] : num[0];
        } else {
            // num[start] < num[mid] means minimum is in mid to end
            int start = 0;
            int end = num.length - 1;
            while (start < end - 1) {
                if (num[end] > num[start]) {
                    return num[start];
                } else {
                    int mid = start + (end - start) / 2;
                    if (num[mid] == num[start]) {
                        start++;
                    } else if (num[mid] > num[start]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }

            return num[start] < num[end] ? num[start] : num[end];
        }
    }
}
