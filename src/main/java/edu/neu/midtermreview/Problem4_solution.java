package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
import java.util.Stack;

public class Problem4_solution {

    public static String removeDuplicateLetters(String s) {
        // Count the frequency of each character
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Stack to store the result characters
        Stack<Character> stack = new Stack<>();
        // Set to check if a character is already in the stack
        boolean[] inStack = new boolean[26];
        
        for (char c : s.toCharArray()) {
            // Decrease the frequency of the current character
            count[c - 'a']--;
            
            // If the character is already in the stack, skip it
            if (inStack[c - 'a']) {
                continue;
            }
            
            // Ensure lexicographical order by removing characters from stack
            // that are greater than the current character and have more occurrences ahead
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            // Add the current character to the stack and mark it as in stack
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Reverse the result to get the correct lexicographical order
        return result.reverse().toString();
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

