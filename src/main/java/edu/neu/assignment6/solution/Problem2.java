package edu.neu.assignment6.solution;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */

import java.util.HashSet;

public class Problem2 {
    
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store the characters in the current window
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character at 'right' pointer is already in the set, slide the left pointer
            while (set.contains(s.charAt(right))) {
                // Remove character at the left pointer from the set and move left pointer forward
                set.remove(s.charAt(left));
                left++;
            }
            // Add the character at 'right' to the set
            set.add(s.charAt(right));
            // Update the maximum length of substring without duplicate characters
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Problem2 lsw = new Problem2();

        // Test case 1
        String testCase1 = "abcabcbb";
        System.out.println("Test case 1: " + lsw.lengthOfLongestSubstring(testCase1));

        // Test case 2
        String testCase2 = "bbbbb";
        System.out.println("Test case 2: " + lsw.lengthOfLongestSubstring(testCase2));

        // Test case 3
        String testCase3 = "pwwkew";
        System.out.println("Test case 3: " + lsw.lengthOfLongestSubstring(testCase3));

        // Test case 4 (Additional test case: Empty string)
        String testCase4 = "";
        System.out.println("Test case 4: " + lsw.lengthOfLongestSubstring(testCase4));

        // Test case 5 (Additional test case: Single character string)
        String testCase5 = "a";
        System.out.println("Test case 5: " + lsw.lengthOfLongestSubstring(testCase5));

        // Test case 6 (Additional test case: All unique characters)
        String testCase6 = "abcdef";
        System.out.println("Test case 6: " + lsw.lengthOfLongestSubstring(testCase6));
    }
}

