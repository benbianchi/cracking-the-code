package com.bianchi.ch1;

import org.junit.Test;

import static org.junit.Assert.*;

import static com.bianchi.ch1.ArraysAndStrings.*;

public class ArraysAndStringsTest {

    /**
     * Question 1
     * 
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     */

    @Test
    public void testNullShouldShortCircuitToFalse() {
        assertFalse(isUnique(null));
    }

    @Test
    public void testEmptyShouldShortCircuitToFalse() {
        assertFalse(isUnique(""));
    }

    @Test
    public void testStringWithDuplicatesIsNotUnique() {
        assertFalse(isUnique("object oriented"));
    }

    @Test
    public void testStringWithoutDuplicatesIsUnique() {
        assertTrue(isUnique("abc"));
    }

    /**
     * Question 1 w/o hashmap gives us a O(N^2)
     */
    @Test
    public void testWithoutHashMapNullShouldShortCircuitToFalse() {
        assertFalse(isUniqueNoHashMap(null));
    }

    @Test
    public void testWithoutHashMapEmptyShouldShortCircuitToFalse() {
        assertFalse(isUniqueNoHashMap(""));
    }

    @Test
    public void testWithoutHashMapStringWithDuplicatesIsNotUnique() {
        assertFalse(isUniqueNoHashMap("object oriented"));
    }

    @Test
    public void testWithoutHashMapStringWithoutDuplicatesIsUnique() {
        assertTrue(isUniqueNoHashMap("abc"));
    }

    /**
     * Question 2
     */
    @Test
    public void testVoidOriginalReturnsFalse() {
        assertFalse(isPermutation(null, "string"));
    }

    @Test
    public void testVoidPotentialReturnsFalse() {
        assertFalse(isPermutation("string", null));
    }

    @Test
    public void testEmptyOriginalReturnsFalse() {
        assertFalse(isPermutation("", "string"));
    }

    @Test
    public void testEmptyPotentialReturnsFalse() {
        assertFalse(isPermutation("string", ""));
    }

    @Test
    public void testFailureCaseReturnsFalse() {
        assertFalse(isPermutation("abc", "d"));
    }

    @Test
    public void testSuccessCaseReturnsTrue() {
        assertFalse(isPermutation("ab", "ba"));
    }

    /**
     * Question 3
     */
    @Test
    public void testConvertToURLNullUrlReturnsNull() {
        assertNull(convertToURL(null, 10));
    }

    @Test
    public void testConvertToURLNullCountReturnsNull() {
        assertNull(convertToURL("mr bobdobalina", null));
    }

    @Test
    public void testConvertToURLSuccessCase() {
        assertEquals(convertToURL("Mr John Smith     ", 13), "Mr%20John%20Smith");
    }

    /**
     * Question 4
     */
    @Test
    public void testIsPalindromeNullYieldsFalse() {
        assertFalse(isPalindromePermutation(null));
    }

    @Test
    public void testIsPalindromeEmptyYieldsEmpty() {
        assertTrue(isPalindromePermutation(""));
    }

    @Test
    public void testIsPalindromeNormal() {
        assertTrue(isPalindromePermutation("aa"));
    }

    @Test
    public void testIsPalindromeNormalWithMidpoint() {
        assertTrue(isPalindromePermutation("aba"));
    }

    @Test
    public void testIsPalindromeNormalWithMidpointJumbled() {
        assertTrue(isPalindromePermutation("aab"));
    }

    @Test
    public void testIsPalindromeNormalCase() {
        assertTrue(isPalindromePermutation("tact coa"));
    }


    @Test
    public void testIsPalindromeIgnoreCase() {
        assertTrue(isPalindromePermutation("TactCoa"));
    }

    /**
     * Question 1.5
     */
    @Test
    public void testIsOneEditAwayNullReturnsNull() {
        assertNull(isOneEditAway(null,"Example"));
        assertNull(isOneEditAway("Example",null));
        assertNull(isOneEditAway(null,null));
    }

    @Test
    public void testIsOneEditAwayInputsAreSame() {
        assertTrue(isOneEditAway("same", "same"));
    }

    @Test
    public void testIsOneEditAwayInputsOneNeedsInsertion() {
        assertTrue(isOneEditAway("sme", "same"));
    }

    @Test
    public void testIsOneEditAwayInputsOneNeedsDeletion() {
        assertTrue(isOneEditAway("same", "same"));
    }


    @Test
    public void testIsOneEditAwayInputsOneNeedsReplacement() {    
        assertTrue(isOneEditAway("same", "same"));
    }

}