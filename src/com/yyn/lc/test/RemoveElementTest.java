//package com.yyn.lc.test;
//
//import com.yyn.lc.Util;
//import com.yyn.lc.array.RemoveElement;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by jiy on 5/10/16.
// */
//public class RemoveElementTest {
//    public final static String TAG = "RemoveElementTest";
//    // Remove Element
//    public  static RemoveElement removeElement = null;
//    @BeforeClass
//    public static void beforeClass(){
//        removeElement = new RemoveElement();
//    }
//
//    @Test
//    public void testRemoveElement(){
//        int[] testArray = {1,2,1,4,5,7,1,3,1};
//        int length = removeElement.removeElement(testArray,1);
//        Util.logD(TAG, "new lenght = " + length);
//        assertEquals(5, length);
//    }
//}