package com.yyn.lc.array;

import com.yyn.lc.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jiy on 5/14/16.
 * <p/>
 * 1. 2 Sum:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.不是从零计数，而是1.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * <p/>
 * 2. 3 Sum:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: Elements in a triplet (a,b,c) must be in non-descending order.(ie, a ≤ b ≤ c) 升序排列
 * The solution set must not contain duplicate triplets.
 * <p/>
 * 3. 3 sum closest
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p/>
 * 4. 4 sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example
 * Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
 * (-1, 0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2, 0, 0, 2)
 * <p/>
 * 5. k sum:
 * Given n unique integers, number k (1<=k<=n) and target.
 * Find all possible k integers where their sum is target.
 * Have you met this question in a real interview? Yes
 * Example
 * Given [1,2,3,4], k = 2, target = 5. Return:
 * [
 * [1,4],
 * [2,3]
 * ]
 */
public class Sum {
    /**
     * @param numbers : An array of Integer
     * @param target  : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;

        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int indexMap = 0; indexMap < numbers.length; indexMap++) {
            // key is value for following search
            // value is index in the array
            // invalid if different indices may have the save value in array
            numberMap.put(numbers[indexMap], indexMap);
        }

        for (int indexArray = 0; indexArray < numbers.length; indexArray++) {
            int gap = target - numbers[indexArray];
            Integer need = numberMap.get(gap);
            if (need != null && need.intValue() != indexArray/* make sure this index is not the same one*/) {
                index1 = indexArray >= need.intValue() ? need.intValue() : indexArray;
                index2 = indexArray >= need.intValue() ? indexArray : need.intValue();
                break;
            }
        }

        return new int[]{index1 + 1, index2 + 1};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();

        Arrays.sort(nums);

        int index = 0;
        while (index < nums.length - 2) {
            int indexFront = index + 1;
            int indexBack = nums.length - 1;

            while (indexFront < indexBack) {
                int sum = nums[index] + nums[indexFront] + nums[indexBack];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[index]);
                    triplet.add(nums[indexFront]);
                    triplet.add(nums[indexBack]);
                    retList.add(triplet);

                    indexFront++;
                    indexBack--;

                    // avoid !used! duplicate numbers
                    // skip front pointer
                    while (indexFront < indexBack && nums[indexFront - 1] == nums[indexFront]) {
                        indexFront++;
                    }
                    // skip back pointer
                    while (indexBack > indexFront && nums[indexBack] == nums[indexBack + 1]) {
                        indexBack--;
                    }
                } else if (sum < 0) {
                    // get a larger number
                    indexFront++;
                } else if (sum > 0) {
                    // get a smaller number
                    indexBack--;
                }
            }

            index++;
            // skip used index with dup
            while (index < nums.length - 1 && nums[index] == nums[index - 1]) {
                index++;
            }
        }

        return retList;
    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target   : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        int ret = target;

        if (numbers.length < 3) {
            //TODO throw exception
        }

        Arrays.sort(numbers);

        // sum of 3 integers
        int tmpSum;
        // distance from the sum to target
        int tmpDis;
        // current minimum distance
        int curDis = Integer.MAX_VALUE;
        for (int index = 0; index < numbers.length - 2; index++) {
            int indexFront = index + 1;
            int indexBack = numbers.length - 1;

            while (indexFront < indexBack) {
                tmpSum = numbers[index] + numbers[indexFront] + numbers[indexBack];
                if (tmpSum > target) {
                    indexBack--;
                    tmpDis = tmpSum - target;
                } else if (tmpSum < target) {
                    indexFront++;
                    tmpDis = target - tmpSum;
                } else {
                    return tmpSum;
                }

                if (tmpDis < curDis) {
                    // save the minimum distance
                    curDis = tmpDis;
                    // save the sum of the 3 number with this distance
                    ret = tmpSum;
                }
            }
        }

        return ret;
    }

    /**
     * @param numbers : Give an array numbers of n integer
     * @param target  : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     * zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();

        if (numbers.length < 4) {
            return retList;
        }

        Arrays.sort(numbers);

        int index0 = 0;
        while (index0 < numbers.length - 3) {
            int index1 = index0 + 1;

            while (index1 < numbers.length - 2) {
                int indexFront = index1 + 1;
                int indexBack = numbers.length - 1;

                while (indexFront < indexBack) {
                    int sum = numbers[index0] + numbers[index1] + numbers[indexFront] + numbers[indexBack];
                    if (sum == target) {
                        ArrayList<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(numbers[index0]);
                        quadruplet.add(numbers[index1]);
                        quadruplet.add(numbers[indexFront]);
                        quadruplet.add(numbers[indexBack]);
                        retList.add(quadruplet);

                        // avoid !used! duplicate numbers
                        // skip front pointer
                        do {
                            indexFront++;
                        }
                        while (indexFront < indexBack && numbers[indexFront - 1] == numbers[indexFront]);

                        // skip back pointer
                        do {
                            indexBack--;
                        }
                        while (indexBack > indexFront && numbers[indexBack] == numbers[indexBack + 1]);
                    } else if (sum < target) {
                        // get a larger number
                        indexFront++;
                    } else if (sum > target) {
                        // get a smaller number
                        indexBack--;
                    }
                }

                // skip used index with dup
                do {
                    index1++;
                }
                while (index1 < numbers.length - 2 && numbers[index1] == numbers[index1 - 1]);
            }

            // skip used index with dup
            do {
                index0++;
            }
            while (index0 < numbers.length - 3 && numbers[index0] == numbers[index0 - 1]);
        }

        return retList;
    }

    /**
     * @param numbers: an integer array.
     * @param k:       a positive integer (k <= length(A))
     * @param target:  a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] numbers, int k, int target) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();

        if (numbers.length < k) {
            return retList;
        }

        Arrays.sort(numbers);
//        Util.logD("kSumII", "sort: " + Arrays.toString(numbers));

        int index0 = 0;
        while (index0 < numbers.length - (k - 1)) {
            if (k == 1) {
                if (numbers[index0] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numbers[index0]);
                    retList.add(list);
                }
            } else if(k == 2){
                int index1 =  index0+1;

                while (index1 < numbers.length) {
                    int tmpSum = numbers[index0] + numbers[index1];
                    if (tmpSum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[index0]);
                        list.add(numbers[index1]);
                        retList.add(list);

                        index1++;
                    } else if (tmpSum < target) {
                        index1++;
                    } else {
                        break;
                    }
                }
            } else {
//                Util.logD("kSumII", "index0: " + index0);
                int sum = numbers[index0];
                // total looped time
                int total = 1;
                // index corresponding to total
                int indexN = index0;
                // save all indices that need to form each result
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(indexN);
                kSumInternal(sum, total, indexN, numbers, target, k, indices,retList);
            }

            index0++;
        }

        return retList;
    }

    private void kSumInternal(int sum, int total, int indexN,
                              int[] numbers, int target, int k,
                              ArrayList<Integer> indices, ArrayList<ArrayList<Integer>> retList) {
//        Util.logD("kSumInternal", "sum=" + sum + ", total=" + total +
//                ", indexN=" + indexN + ", numbers=" + numbers + ", target=" + target + ", k=" + k);
//        Util.logD("kSumInternal", "retList = " + retList);
//        Util.logD("kSumInternal", "indices = " + indices);
        if (total < k - 2) {
//            Util.logD("kSumInternal", "recursion");

            indexN++;
            total++;
            for (int curIndex = indexN; curIndex < numbers.length - (k - total); curIndex++) {
//                Util.logD("kSumInternal", "" + curIndex);
                int tmpSum = sum;
                tmpSum += numbers[curIndex];
                ArrayList<Integer> tmpIndices = (ArrayList<Integer>) indices.clone();
                tmpIndices.add(curIndex);
                kSumInternal(tmpSum, total, curIndex, numbers, target, k, tmpIndices, retList);
            }
        } else {
            int indexFront = indexN + 1;
            int indexBack = numbers.length - 1;

            while (indexFront < indexBack) {
//                Util.logD("kSumInternal", "indexFront: " + indexFront + ", indexBack: " + indexBack);
                int currentSum = sum;
                currentSum += numbers[indexFront] + numbers[indexBack];
                if (currentSum == target) {
                    ArrayList<Integer> tmpList = new ArrayList<>();
                    for (int i = 0; i < indices.size();i++){
                        tmpList.add(numbers[indices.get(i)]);
                    }
                    tmpList.add(numbers[indexFront++]);
                    tmpList.add(numbers[indexBack--]);
                    retList.add(tmpList);

//                    Util.logD("kSumInternal", "!add " + tmpList.toString());
                } else if (currentSum < target) {
                    // get a larger number
                    indexFront++;
                } else if (currentSum > target) {
                    // get a smaller number
                    indexBack--;
                }
            }
        }
    }

}
