package com.bianchi.ch1;

import junit.framework.TestCase;

public class ArraysAndStringsTest extends TestCase {

    /**
     * Question 1
     * 
     * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     */

     public void testNullShouldShortCircuitToFalse () {
         assertFalse(ArraysAndStrings.isUnique(null));
     }

     public void testEmptyShouldShortCircuitToFalse () {
         assertFalse(ArraysAndStrings.isUnique(""));
     }

     public void testStringWithDuplicatesIsNotUnique() {
         assertFalse(ArraysAndStrings.isUnique("object oriented"));
     }

     public void testStringWithoutDuplicatesIsUnique() {
         assertTrue(ArraysAndStrings.isUnique("abc"));
     }

     /**
      * Question 1 w/o hashmap gives us a O(N^2)
      */
     public void testWithoutHashMapNullShouldShortCircuitToFalse () {
         assertFalse(ArraysAndStrings.isUniqueNoHashMap(null));
     }

     public void testWithoutHashMapEmptyShouldShortCircuitToFalse () {
         assertFalse(ArraysAndStrings.isUniqueNoHashMap(""));
     }

     public void testWithoutHashMapStringWithDuplicatesIsNotUnique() {
         assertFalse(ArraysAndStrings.isUniqueNoHashMap("object oriented"));
     }

     public void testWithoutHashMapStringWithoutDuplicatesIsUnique() {
         assertTrue(ArraysAndStrings.isUniqueNoHashMap("abc"));
     }

     /**
      * Question 2
      */
    public void testVoidOriginalReturnsFalse() {
        assertFalse(ArraysAndStrings.isPermutation(null, "string"));
    }

    public void testVoidPotentialReturnsFalse() {
        assertFalse(ArraysAndStrings.isPermutation("string", null));
    }

    public void testEmptyOriginalReturnsFalse() {
        assertFalse(ArraysAndStrings.isPermutation("", "string"));
    }

    public void testEmptyPotentialReturnsFalse() {
        assertFalse(ArraysAndStrings.isPermutation("string", ""));
    }

    public void testFailureCaseReturnsFalse() {
        assertFalse(ArraysAndStrings.isPermutation("abc", "d"));
    }

    public void testSuccessCaseReturnsTrue() {
        assertFalse(ArraysAndStrings.isPermutation("ab", "ba"));
    }
}