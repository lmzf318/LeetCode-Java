package com.yyn.lc.array;

/**
 * Created by jiy on 5/20/16.
 * <p>
 * 1.
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *  1.  Integers in each row are sorted from left to right.
 *  2.  The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * 2.
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * This matrix has the following properties:
 *  1.  Integers in each row are sorted from left to right.
 *  2.  Integers in each column are sorted from up to bottom.
 *  3.  No duplicate integers in each row or column.
 */
public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowIndex = 0;
        int columIndex = matrix[0].length - 1;
        while (rowIndex < matrix.length && columIndex >= 0) {
            if (target > matrix[rowIndex][columIndex]) {
                rowIndex++;
            } else if (target < matrix[rowIndex][columIndex]) {
                columIndex--;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrixii(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int sum = 0;
        int rowIndex = 0;
        int columIndex = matrix[0].length - 1;
        while (rowIndex < matrix.length && matrix[rowIndex][0] <= target) {
            if (target > matrix[rowIndex][columIndex]) {
                rowIndex++;
                columIndex = matrix[0].length - 1;
            } else if (target < matrix[rowIndex][columIndex]) {
                if(columIndex == 0){
                    break;
                }
                columIndex--;
            } else {
                sum++;
                rowIndex++;
                columIndex = matrix[0].length - 1;
            }
        }

        return sum;
    }
}
