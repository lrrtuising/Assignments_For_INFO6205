package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rushdi
 */

import java.util.*;

public class Problem1 {
    
    // IMPLEMENT THE BELOW FUNCTION
    public static List<List<Integer>> permute(int[] nums) {
        
        // UPDATE THIS RETURN STATEMENTS ALSO!!!!
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, current, nums, used);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, used);
            used[i] = false;
            current.remove(current.size() - 1);
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

