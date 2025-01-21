package edu.neu.assignment2;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Stack;

/**
 *
 * @author purvamsheth
 */

public class Problem5 {
    
    public static int solution(String s) {
        // WRITE YOUR CODE HERE!!!!
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;

        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength; // UPDATE THIS LINE OF CODE ALSO!!
    }

    public static void main(String[] args) {
        String s = "(()))())(";
        System.out.println("Longest Valid Parentheses : " + solution(s)); // EXPECTED RESULT 4

        // ADD YOU TEST CASES HERE!!!
        String s1 = "(()";
        System.out.println("Longest Valid Parentheses : " + solution(s1)); // EXPECTED RESULT 2

        String s2 = ")()())";
        System.out.println("Longest Valid Parentheses : " + solution(s2)); // EXPECTED RESULT 4

        String s3 = "(()())";
        System.out.println("Longest Valid Parentheses : " + solution(s3)); // EXPECTED RESULT 6

        String s4 = ")))(((";
        System.out.println("Longest Valid Parentheses : " + solution(s4)); // EXPECTED RESULT 0
    }

    
}
