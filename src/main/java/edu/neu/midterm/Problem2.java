package edu.neu.midterm;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Problem2 {

    // IMPLEMENT THE BELOW FUNCTION!
    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }
        // update return statement as well!
        return -1;
    }

    // Main method to run some test cases
    public static void main(String[] args) {
        // Test case 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1)); // Output: 0

        // Test case 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2)); // Output: -1

        // If needed add additional test cases here!!
        // Test case 3
        String haystack3 = "butsad";
        String needle3 = "sad";
        System.out.println(strStr(haystack3, needle3)); // Output: 3

    }
}

