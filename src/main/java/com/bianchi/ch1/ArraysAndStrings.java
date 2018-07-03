package com.bianchi.ch1;

import java.util.HashMap;

import javax.swing.JTextArea;

/**
 * The following code are my attempts at the answer of Cracking the Code Interview's questions.
 * 
 * All Questions have associated tests, and yes tests are written before the question is answered.
 */

 public class ArraysAndStrings {

    /**
     * Question 1:
     * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     */

    /**
     * Check to see if a string has all unique characters -- no duplicate characters.
     * O(n)
     * 
     * @param stringToCheck the string to check for duplicate characters in.
     */
    public static boolean isUnique(String stringToCheck) {        
        if (stringToCheck == null || stringToCheck == "") {
            return false;
        }

        // Use a hashmap -- they reduce our runtime from O(N^2) to O(N)
        HashMap<Character, Boolean> characterPresenceHashmap = new HashMap<Character, Boolean>();

        for (char character : stringToCheck.toCharArray()) {
            if (characterPresenceHashmap.containsKey(character)) {
                return false;
            }

            characterPresenceHashmap.put(character, true);
        }

        return true;
    }

    /**
     * Checks to see if a string is unique without using a hashmap. This function is slower,
     * O(n^2)
     * 
     * @param stringToCheck the string we are checking for duplicates in.
     */
    public static boolean isUniqueNoHashMap(String stringToCheck) {        
        if (stringToCheck == null || stringToCheck == "") {
            return false;
        }

        for (int i = 0; i < stringToCheck.length(); i++) {
            for (int j = 0; j < stringToCheck.length(); j++) {
                /**
                 * Dont cause a false positive if we are looking at the same index.
                 */
                if (i == j) {
                    continue;
                }

                if (stringToCheck.toCharArray()[i] == stringToCheck.toCharArray()[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Checks to see if a string is a permutation of another string
     * 
     * @param original The Base string
     * @param potentialPermutation The string that may be a permutation of the original string
     * 
     * @returns boolean whether or not the potentialPermutation is a permutation of the original string
     */
    public static boolean isPermutation(String original, String potentialPermutation) {
        /**
         * Quick Short Circuit.
         */
        if (original != null || original == "" || potentialPermutation != null || potentialPermutation == "") {
            return false;
        }

        /**
         * Load all characters from the original string into a hashmap.
         * Then check each character from potentialPermutation is in that hashmap
         */
        HashMap<Character, Boolean> characterPresenceHashMap = new HashMap<Character,Boolean>();

        for (char character : original.toCharArray()) {
            characterPresenceHashMap.put(character, true);
        }
        
        for (char characterThatMayBeInOriginal : original.toCharArray()) {
            if (!characterPresenceHashMap.containsKey(characterThatMayBeInOriginal)) {
                return false;
            }
        }

        return true;        
    }
 }