package edu.neu.assignment8; /**
 * @author name
 */

import java.util.*;

class Problem2 {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Implement the below function!!!
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currEffort = current[0];
            int row = current[1];
            int col = current[2];

            if (row == rows - 1 && col == cols - 1) {
                return currEffort;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(currEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }
        return -1; // No path found
    }


    // Main method with test cases
    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        // Test Case 1
        int[][] heights1 = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println("Test Case 1:");
        System.out.println("Input: [[1,2,2],[3,8,2],[5,3,5]]");
        System.out.println("Result: " + solution.minimumEffortPath(heights1));

        // Test Case 2
        int[][] heights2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: [[1,2,3],[3,8,4],[5,3,5]]");
        System.out.println("Result: " + solution.minimumEffortPath(heights2));

        // Test Case 3
        int[][] heights3 = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]");
        System.out.println("Result: " + solution.minimumEffortPath(heights3));
    }
}

