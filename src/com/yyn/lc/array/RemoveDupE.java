package com.yyn.lc.array;

/**
 * Created by jiy on 5/10/16.
 * <p>
 * 1. Given a sorted array, remove the duplicates in place such that > each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 2. Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDupE {
    public int removeDup1(int[] nums) {
        assert nums != null;

        if (nums.length == 0) {
            return 0;
        }

        int newIndex = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[newIndex] != nums[index]) {
                nums[++newIndex] = nums[index];
            }
        }

        return (newIndex + 1);
    }

    public int removeDup2(int[] nums) {
        assert nums != null;

        if (nums.length == 0) {
            return 0;
        }

        int newIndex = 0;
        int dup = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[newIndex] == nums[index]) {
                dup++;
            }

            if (nums[newIndex] != nums[index]) {
                nums[++newIndex] = nums[index];
                dup = 0;
            }else if(dup < 2){
                nums[++newIndex] = nums[index];
            }
        }

        return (newIndex + 1);
    }
}
