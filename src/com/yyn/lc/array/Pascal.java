package com.yyn.lc.array;

import com.yyn.lc.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiy on 5/12/16.
 * <p>
 * 1. Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5, Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 2. Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3, Return [1,3,3,1].
 */
public class Pascal {
    // 1. 第index层有index+1个元素, index starts from 0
    // 2. 每层第一个以及最后一个元素值为1
    // 3. 对于第index（index > 1）层第layerIndex（layerIndex > 0 && layerIndex < index-1）个元素
    // A[index][layerIndex]，A[index][layerIndex] = A[index-1][layerIndex-1] + A[index-1][layerIndex]
    public List<List<Integer>> getPTriangle1(int numRows) {
        List<List<Integer>> retList = new ArrayList<>();

        if (numRows == 0) {
            return retList;
        }

        // numRows > 0
        List<Integer> currentLayer = new ArrayList<>();
        currentLayer.add(1);
        retList.add(currentLayer);

        for (int index = 1; index < numRows; index++) {
            currentLayer = new ArrayList<>(index + 1);
            currentLayer.add(1);

            for (int layerIndex = 1; layerIndex < index; layerIndex++) {
                currentLayer.add(
                        (retList.get(index - 1)).get(layerIndex - 1) +
                                (retList.get(index - 1)).get(layerIndex)
                );
            }
            currentLayer.add(1);
            retList.add(currentLayer);
        }

        return retList;
    }

    public List<Integer> getPTriangle2(int rowIndex) {
        // size is rowIndex+1
        List<Integer> retList = new ArrayList<>(rowIndex + 1);

        // first element
        retList.add(1);

        // rowIndex > 0
        // A[n][m] = A[n-1][m-1] + A[n-1][m]
        for (int index = 1; index <= rowIndex; index++) {
            // middle elements
            for (int currentIndex = retList.size() - 1; currentIndex > 0; currentIndex--) {
                retList.set(currentIndex, retList.get(currentIndex) + retList.get(currentIndex - 1));
            }
            // last element
            retList.add(1);
        }

        return retList;
    }
}
