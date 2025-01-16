package edu.neu.assignment1;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Purvam Sheth
 */

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        // WRITE YOUR CODE HERE!!
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // UPDATE THIS LINE OF CODE ALSO!
    }

    public static void main(String[] args) {
        // SAMPLE CASE 1
        String input1 = "({[()]})";
        System.out.println(isBalanced(input1) ? "Balanced" : "Not Balanced"); // EXPECTED RESULT: Balanced
        // SAMPLE CASE 2
        String input2 = "({){})))";
        System.out.println(isBalanced(input2) ? "Balanced" : "Not Balanced"); // EXPECTED RESULT : Not Balanced
        // ADD YOUR TEST CASES HERE!!!
        String input3 = "({[)]}";
        System.out.println(isBalanced(input3) ? "Balanced" : "Not Balanced"); // EXPECTED RESULT : Not Balanced
    }
}

