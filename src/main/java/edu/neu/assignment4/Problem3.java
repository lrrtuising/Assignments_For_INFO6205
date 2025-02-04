package edu.neu.assignment4;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author purvamsheth
 */

import java.util.*;

public class Problem3 {

    // IMPLEMENT THE BELOW FUNCTION!!!
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        minHeap.offer(1L);
        seen.add(1L);
        long uglyNumber = 1;
        for (int i = 0; i < n; i++) {
            uglyNumber = minHeap.poll();
            long[] factors = {2, 3, 5};
            for (long factor : factors) {
                long newUglyNumber = uglyNumber * factor;
                if (!seen.contains(newUglyNumber)) {
                    minHeap.offer(newUglyNumber);
                    seen.add(newUglyNumber);
                }
            }
        }

        return (int) uglyNumber; // Return the nth ugly number
    }

    public static void main(String[] args) {
        Problem3 solution = new Problem3();

        // Test case 1: Find the 10th ugly number
        int n = 10;
        System.out.println("The " + n + "th ugly number is: " + solution.nthUglyNumber(n)); // Expected output: 12

        // Test case 2: Find the 1st ugly number
        n = 1;
        System.out.println("The " + n + "st ugly number is: " + solution.nthUglyNumber(n)); // Expected output: 1

        // Test case 3: Find the 15th ugly number
        n = 15;
        System.out.println("The " + n + "th ugly number is: " + solution.nthUglyNumber(n)); // Expected output: 24
    }
}

