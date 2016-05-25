package com.yyn.lc.array;

/**
 * Created by jiy on 5/10/16.
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 * Given [1,2,3] which represents 123, return [1,2,4].
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne {

    // xxxx9 current is (9+1) mod 10 == 0, carry is (9+1)/10 == 1.
    public int[] plusOne(int[] digits){
        int carry = 1;// plus 1
        for(int index = digits.length-1; index >= 0; index--){
            int tmp = digits[index] + carry;
            digits[index] = tmp%10;
            carry = tmp/10;

            if(carry == 0){
                return digits;
            }
        }

        // carry > 0, need to add it at the most significant digit
        int[] retDigits = new int[digits.length+1];
        retDigits[0] = carry;// other digits are all '0'
        //System.arraycopy(digits,0,retDigits,1,digits.length);
        return retDigits;
    }
}
