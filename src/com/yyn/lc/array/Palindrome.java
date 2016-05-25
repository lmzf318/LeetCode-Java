package com.yyn.lc.array;

import com.yyn.lc.Util;

/**
 * Created by jiy on 5/20/16.
 * <p>
 * 1. Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * 2. Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int tmp = x;
            int y = 0;
            while (x != 0) {
                y = y * 10 + x % 10;
                Util.logD("isPalindrome", "y: " + y);
                x = x / 10;
                Util.logD("isPalindrome", "x: " + x);
            }
            return (y == tmp);
        }
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.equals("")){
            return true;
        }

        s = s.replaceAll("[^A-Za-z0-9]", "");
        Util.logD("isPalindrome", "after remove non-alphanumeric s: "+ s);

        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
