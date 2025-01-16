package edu.neu.assignment1;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Stack;

/**
 * @author Purvam Sheth
 */

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        // WRITE YOUR CODE HERE!!!
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); // UPDATE THIS LINE OF CODE ALSO !!!!
    }

    public static void main(String[] args) {

        // SAMPLE CASE 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + evalRPN(tokens1)); // Output: 9

        // SAMPLE CASE 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result: " + evalRPN(tokens2)); // Output: 6

    }
}

