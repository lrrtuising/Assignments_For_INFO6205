package edu.neu.assignment7;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author INFO 6250
 */

public class Problem2 {

    // implement the below function!!
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                minutes++;
            }
        }
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        // Test Case 1
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test Case 1 - Result: " + solution.orangesRotting(grid1)); // Output: 4

        // Test Case 2
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("Test Case 2 - Result: " + solution.orangesRotting(grid2)); // Output: -1

        // Test Case 3
        int[][] grid3 = {
                {0, 2}
        };
        System.out.println("Test Case 3 - Result: " + solution.orangesRotting(grid3)); // Output: 0
    }
}

