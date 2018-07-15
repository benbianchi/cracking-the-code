package com.bianchi.ch1;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

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
     * Question 2
     * 
     * Check to see if a sting is a palindrome.
     */

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

    /**
     * Question 3:
     * 
     * Write a method toWrite a method to replace all the spaces in a string with ‘%20’.
     * You may assume that the string has sufficient space at the end to hold the additional characters, 
     * and that you are given the “true” length of the string.
     */

     /**
      * 
      * @param stringToBecomeURL the string we are converting to a url
      * @param trueLengthOfString an integer that is the true length of the 
      *
      * @return String a string that is the url representation of the URL.
      */
    public static String convertToURL(String stringToBecomeURL, Integer trueLengthOfString) {
        
        if (stringToBecomeURL == null || trueLengthOfString == null) {
            return null;
        }

        char[] urlCharacters = stringToBecomeURL.toCharArray();
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < trueLengthOfString; i++) {
            if (urlCharacters[i] == ' ') {
                sBuilder.append("%20");
            } else {
                sBuilder.append(urlCharacters[i]);
            }
        }
        return sBuilder.toString();
    }

    /**
     * Question 1.4
     * Given a string, check to see if it is a permutation of a palindrome.
     */

    /**
     * Checks to see if a string is a permutation of a palindrome.
     * 
     * Under the covers, this looks to see if the occurances of each character is divisible
     * by two, and only allows one character to have one occurance. This singular character can be the
     * midpoint.
     * 
     * @param permutation The string we are checking to see is a permutation of a Palindrome
     * 
     * @return Boolean whether or not this string is a permutation of a palindrome.
     */
    public static Boolean isPalindromePermutation(String permutation) {
        if (permutation  == null) {
            return false;
        }

        HashMap<Character, Integer> characterOccuranceMap = new HashMap<>();

        for (char character : permutation.toLowerCase().toCharArray()) {
            if (character == ' ') {
                continue;
            }

            if (characterOccuranceMap.containsKey(character)) {
                Integer previousValue = characterOccuranceMap.get(character);
                characterOccuranceMap.put(character, ++previousValue);
            } else {
                characterOccuranceMap.put(character, 1);
            }
        }
        
        if (permutation.length() % 2 == 0) {
            Boolean midpointFound = false;
            for (Entry<Character, Integer> characterOccuranceCountEntry : characterOccuranceMap.entrySet()) {
                if (characterOccuranceCountEntry.getValue() % 2 == 1) {
                    if (midpointFound) {
                        return false;
                    } else {
                        midpointFound = true;
                    }
                }
            }
        }
        return true;
    }

    public static Boolean isOneEditAway(String inputOne, String inputTwo) {
        if (inputOne == null || inputTwo == null) {
            return null;
        }

        if (inputOne.equals(inputTwo)) {
            return true;
        }

        if (Math.abs(inputOne.length() - inputTwo.length() > 1)) {
            return false;
        }

        // After input sanitization and sanity check there are 3 cases here:
        // 1. inputOne is too short -- try inserting
        // 2. inputOne is too long -- try deleting
        // 3. inputOne is the same size -- try changing

        if (inputOne.length() < inputTwo.length()) {

        }
    }

    private static Boolean attemptInsertion(String inputOne, String inputTwo) {
        for (int i = 0; i < inputOne.length(); i++) {
            if (inputOne.charAt(i) != inputTwo.charAt(i))   
        }
    }
 }