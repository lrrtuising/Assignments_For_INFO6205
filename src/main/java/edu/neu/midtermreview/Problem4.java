package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rushdi
 */
import java.util.Stack;

public class Problem4 {

    // IMPLEMENT THE BELOW FUNCTION!!
    public static String removeDuplicateLetters(String s) {
        boolean[] inResult = new boolean[26];

        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
    
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inResult[c - 'a']) continue;
        
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                inResult[stack.pop() - 'a'] = false;
            }
        
            stack.push(c);
            inResult[c - 'a'] = true;
        }
    
        StringBuilder result = new StringBuilder();
        for (char c : stack) result.append(c);
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "bcabc",        // Expected output: "abc"
            "cbacdcbc",     // Expected output: "acdb"
            "aaaa",         // Expected output: "a"
            "abacb",        // Expected output: "abc"
            "ecbacba",      // Expected output: "abc"
            "cdadabcc"      // Expected output: "adbc"
        };
        
        // Test the function with all test cases
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " -> Output: " + removeDuplicateLetters(testCase));
        }
    }
}

