package edu.neu.assignment6;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author
 */

import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    // Implement the below function!!!
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // Update return type aswell!!!
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

