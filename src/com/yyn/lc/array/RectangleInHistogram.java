package com.yyn.lc.array;

import com.yyn.lc.Util;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Jimi on 5/18/2016.
 * 1.
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 2.
 * Given a 2D boolean matrix filled with False and True,
 * find the largest rectangle containing all True and return its area.
 */
public class RectangleInHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        LinkedList<Integer> stackList = new LinkedList<>();
        stackList.push(0);

        int max = 0;
        for (int index = 1; index < height.length; ) {
            Util.logD("largestRectangleArea", "before handle, list is " + stackList);
            Util.logD("largestRectangleArea", "height[index] " + height[index]);
            Util.logD("largestRectangleArea", "height[stackList.peekLast()] " +
                    (stackList.isEmpty() ? "empty" : height[stackList.peekLast()]));
            if (stackList.isEmpty() || height[index] >= height[stackList.peekLast()]) {
                Util.logD("largestRectangleArea", "push back " + height[index]);
                stackList.addLast(index);
                index++;
            } else {
                int tmpIndex = stackList.pollLast();
                if (stackList.isEmpty()) {
                    // empty means previous elements are in a descending order
                    max = max > (height[tmpIndex] * index) ? max : (height[tmpIndex] * index);
                } else {
                    int recArea = height[tmpIndex] * (index - stackList.peekLast() - 1);
                    max = max > recArea ? max : recArea;
                }

                Util.logD("largestRectangleArea", "pop back, max is " + max);
            }
        }

        // example: 1,2,3,4,5
        while (!stackList.isEmpty()) {
            int tmpIndex = stackList.pollLast();
            if (stackList.isEmpty()) {
                max = max > (height[tmpIndex] * height.length) ? max : (height[tmpIndex] * height.length);
            } else {
                int recArea = height[tmpIndex] * (height.length - stackList.peekLast() - 1);
                max = max > recArea ? max : recArea;
            }

            Util.logD("largestRectangleArea", "pop back, max is " + max);
        }

        return max;
    }

    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int ret = 0;

        int length0 = matrix.length;
        int length1 = matrix[0].length;
        int[] height = new int[length1];

        for (int index0 = 0; index0 < length0; index0++) {
            for (int index1 = 0; index1 < length1; index1++) {
                if (matrix[index0][index1]) {
                    // True
                    height[index1]++;
                } else {
                    // False
                    height[index1] = 0;
                }
            }

            ret = Math.max(ret, largestRectangleArea(height));
        }

        return ret;
    }
}
