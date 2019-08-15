package com.bianchi.ch1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * The following code are my attempts at the answer of Cracking the Code
 * Interview's questions.
 * 
 * All Questions have associated tests, and yes tests are written before the
 * question is answered.
 */

public class ArraysAndStrings {

    /**
     * Question 1: Implement an algorithm to determine if a string has all unique
     * characters. What if you cannot use additional data structures?
     */

    /**
     * Check to see if a string has all unique characters -- no duplicate
     * characters. O(n)
     * 
     * @param stringToCheck the string to check for duplicate characters in.
     */
    public static boolean isUnique(String stringToCheck) {
        if (stringToCheck == null || stringToCheck == "") {
            return false;
        }

        // Use a hashmap -- they reduce our runtime from O(N^2) to O(N)
        HashSet<Character> characterSet = new HashSet<>();

        for (char character : stringToCheck.toCharArray()) {
            Character lowerCase = Character.toLowerCase(character);
            if (characterSet.contains(lowerCase)) {
                return false;
            }

            characterSet.add(lowerCase);
        }

        return true;
    }

    /**
     * Checks to see if a string is unique without using a hashmap. This function is
     * harder, to understand, but is more efficient
     * 
     * @param stringToCheck the string we are checking for duplicates in.
     */
    public static boolean isUniqueNoHashMap(String stringToCheck) {
        if (stringToCheck == null || stringToCheck == "") {
            return false;
        }

        int buildingBitChecker = 0;

        for (int i = 0; i < stringToCheck.length(); i++) {
            int currentChar = stringToCheck.charAt(i);

            int asBits = 1 << (currentChar - 'a');

            if ((asBits & buildingBitChecker) > 0) {
                return false;
            }

            buildingBitChecker = buildingBitChecker | asBits;
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
     * @param original             The Base string
     * @param potentialPermutation The string that may be a permutation of the
     *                             original string
     * 
     * @returns boolean whether or not the potentialPermutation is a permutation of
     *          the original string
     */
    public static boolean isPermutation(String original, String potentialPermutation) {
        /**
         * Quick Short Circuit.
         */
        if (original != null || original == "" || potentialPermutation != null || potentialPermutation == "") {
            return false;
        }

        /**
         * Sort the arrays and check em.
         */
        List<Character> sortedOriginalString = original.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> sortedPotentialPermutation = potentialPermutation.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        return sortedOriginalString.equals(sortedPotentialPermutation);
    }

    /**
     * Question 3:
     * 
     * Write a method toWrite a method to replace all the spaces in a string with
     * ‘%20’. You may assume that the string has sufficient space at the end to hold
     * the additional characters, and that you are given the “true” length of the
     * string.
     */

    /**
     * 
     * @param stringToBecomeURL  the string we are converting to a url
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
     * Question 1.4 Given a string, check to see if it is a permutation of a
     * palindrome.
     */

    /**
     * Checks to see if a string is a permutation of a palindrome.
     * 
     * Under the covers, this looks to see if the occurances of each character is
     * divisible by two, and only allows one character to have one occurance. This
     * singular character can be the midpoint.
     * 
     * @param permutation The string we are checking to see is a permutation of a
     *                    Palindrome
     * 
     * @return Boolean whether or not this string is a permutation of a palindrome.
     */
    public static Boolean isPalindromePermutation(String permutation) {
        if (permutation == null) {
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

        if (Math.abs(inputOne.length() - inputTwo.length()) > 1) {
            return false;
        }

        // After input sanitization and sanity check there are 3 cases here:
        // 1. inputOne is too short -- try inserting
        // 2. inputOne is too long -- try deleting
        // 3. inputOne is the same size -- try changing

        String shorter = inputOne.length() > inputTwo.length() ? inputTwo : inputOne;
        String longer = inputOne.length() > inputTwo.length() ? inputOne : inputTwo;

        int shorterIndex = 0;
        int longerIndex = 0;
        boolean bDifference = false;

        while (longerIndex < longer.length() && shorterIndex < shorter.length()) {

            // if we have found a difference:
            if (shorter.charAt(shorterIndex) != longer.charAt(longerIndex)) {

                if (bDifference == true)
                    return false;
                bDifference = true;

                if (shorter.length() == longer.length()) {
                    shorterIndex++;
                }
            } else {
                shorterIndex++;
            }
            longerIndex++;
        }

        return true;
    }

    /**
     * Compress a string to the number of occurance of a given character to the
     * streak number ex:
     * 
     * aaa = a3
     * 
     * if the compressed string is longer than the uncompressed string, then return
     * the uncompressed string.
     * 
     * @param compressable the string to compress
     * @return
     */
    public static String compressString(String compressable) {
        if (compressable == null) {
            return null;
        }

        if (compressable.length() == 0) {
            return "";
        }

        Character currentChar = compressable.charAt(0);
        int currentStreak = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < compressable.length(); i++) {
            if (compressable.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                sb.append(currentChar);
                sb.append(currentStreak);
                currentStreak = 1;
                currentChar = compressable.charAt(i);
            }
        }

        sb.append(currentChar);
        sb.append(currentStreak);
        String compressed = sb.toString();
        return compressable.length() > compressed.length() ? compressed : compressable;
    }

    public static int[][] rotateMatrix(int[][] originalMatrix) {

        int[][] newMatrix = originalMatrix.clone();

        for (int row = 0; row < originalMatrix.length; row++) {
            int rowOffset = originalMatrix.length - 1 - row;
            for (int col = 0; col < originalMatrix.length; col++) {
                int columnOffset = originalMatrix.length - 1 - col;

                newMatrix[columnOffset][rowOffset] = originalMatrix[row][row];

            }

        }

        return newMatrix;
    }

    /**
     * 
     */
    public static int[][] zeroOutMatrixRowAndColumn(int[][] originalMatrix) {

        int[][] newMatrix =  new int[originalMatrix.length][originalMatrix.length];
 
        for (int row = 0; row < originalMatrix.length; row++) {
            for (int col = 0; col < originalMatrix.length; col++) {
                newMatrix[row][col] = originalMatrix[row][col];
            }
        }
        

        for (int row = 0; row < originalMatrix.length; row++) {
            for (int col = 0; col < originalMatrix.length; col++) {
                if (originalMatrix[row][col] == 0) {
                    zeroOutRow(newMatrix, row);
                    zeroOutColumn(newMatrix, row);
                }
            }

        }

        return newMatrix;
    }

    /**
     * Zero out a row
     */
    private static int[][] zeroOutRow(int[][] matrix, int rowToBeZeroed) {
        for (int col = 0; col < matrix.length; col++) {
            matrix[rowToBeZeroed][col] = 0;
        }
        return matrix;
    }

    /**
     * Zero out a column
     */
    private static int[][] zeroOutColumn(int[][] matrix, int columnToBeZeroed) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][columnToBeZeroed] = 0;
        }
        return matrix;
    }

    /**
     * Question 1.9
     */
    public static boolean isSubstring(String original, String substring) {

        if (original.length() != substring.length()) {
            return false;
        }

        StringBuilder prePartitionStringBuilder = new StringBuilder();
    
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != substring.charAt(0)) {
                prePartitionStringBuilder.append(original.charAt(i));
            } else{
                
                String built = original.substring(i, original.length()) + prePartitionStringBuilder.toString();

                return built.equals(substring);
            }
        }

        return false;
    }
}