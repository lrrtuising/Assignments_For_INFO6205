package edu.neu.assignment3;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
import java.util.Arrays;
import java.util.LinkedList;

public class Problem2 {

    // IMPLEMENT THE BELOW FUNCTION
    public static int[][] merge(int[][] intervals) {
        // WRITE YOUR CODE HERE!!
        if (intervals.length == 0 || intervals.length <= 0) {
            return intervals;
        }
        // Bubble Sort
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = merged.getLast();

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]); // UPDATE RETURN STATEMENT ALSO
    }

    public static void main(String[] args) {
        // Test Case 1: Regular case with overlapping intervals
        int[][] intervals1 = {{1, 3}, {2, 4}, {5, 7}, {6, 8}};
        int[][] result1 = merge(intervals1);
        System.out.println("Merged intervals 1: " + Arrays.deepToString(result1)); // Expected: [[1, 4], [5, 8]]

        // Test Case 2: No overlapping intervals
        int[][] intervals2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result2 = merge(intervals2);
        System.out.println("Merged intervals 2: " + Arrays.deepToString(result2)); // Expected: [[1, 2], [3, 4], [5, 6]]

        // Test Case 3: All intervals overlap
        int[][] intervals3 = {{1, 10}, {2, 6}, {3, 8}};
        int[][] result3 = merge(intervals3);
        System.out.println("Merged intervals 3: " + Arrays.deepToString(result3)); // Expected: [[1, 10]]

        // Test Case 4: Empty intervals array
        int[][] intervals4 = {};
        int[][] result4 = merge(intervals4);
        System.out.println("Merged intervals 4: " + Arrays.deepToString(result4)); // Expected: []

        // Test Case 5: Single interval
        int[][] intervals5 = {{1, 5}};
        int[][] result5 = merge(intervals5);
        System.out.println("Merged intervals 5: " + Arrays.deepToString(result5)); // Expected: [[1, 5]]
    }
}

