package com.yyn.lc.array;

/**
 * Created by jiy on 5/10/16.
 * <p>
 * Given an array and a value, remove all instances of that > value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    // in place means change the array itself
    public int removeElement(int[] array, int value) {
        assert array != null;

        int newIndex = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] == value) {
                continue;
            } else {
                // move unequal elements to first
                array[newIndex] = array[index];
                newIndex++;
            }
        }

        return newIndex;
    }
}
