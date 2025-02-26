package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rushdi
 */

import java.util.*;

public class Problem1_solution {
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // Base case: If tempList size equals nums length, add a copy to the result
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Iterate through nums array
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip already used numbers
            
            used[i] = true; // Mark number as used
            tempList.add(nums[i]); // Add number to current permutation
            
            backtrack(result, tempList, nums, used); // Recursive call
            
            // Backtrack: Remove last element and mark it as unused
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Permutations of [1, 2, 3]: " + permute(nums1));
        
        int[] nums2 = {0, 1};
        System.out.println("Permutations of [0, 1]: " + permute(nums2));
        
        int[] nums3 = {1};
        System.out.println("Permutations of [1]: " + permute(nums3));
        
        int[] nums4 = {4, 5, 6, 7};
        System.out.println("Permutations of [4, 5, 6, 7]: " + permute(nums4));
    }
}

