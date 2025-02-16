package edu.neu.assignment5;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author purvamsheth
 */

public class Problem1 {
    // implement the below function!!!
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    // Helper function to test the code with a given test case
    public static void main(String[] args) {
        Problem1 solution = new Problem1();
        
        // Test Case 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);
        
        System.out.println("Test Case 1: " + solution.rangeSumBST(root1, 7, 15)); // Expected: 32 (7 + 10 + 15)
        
        // Test Case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(9);
        
        System.out.println("Test Case 2: " + solution.rangeSumBST(root2, 4, 9)); // Expected: 32 (4 + 5 + 6 + 8 + 9)
        
        // Test Case 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + solution.rangeSumBST(root3, 1, 1)); // Expected: 1 (Only root value is within range)
        
        // Test Case 4 (Empty Tree)
        TreeNode root4 = null;
        System.out.println("Test Case 4: " + solution.rangeSumBST(root4, 1, 10)); // Expected: 0 (Tree is empty)
        
        // Test Case 5 (All Nodes within range)
        TreeNode root5 = new TreeNode(10);
        root5.left = new TreeNode(5);
        root5.right = new TreeNode(15);
        root5.left.left = new TreeNode(3);
        root5.left.right = new TreeNode(7);
        root5.right.left = new TreeNode(12);
        root5.right.right = new TreeNode(18);
        
        System.out.println("Test Case 5: " + solution.rangeSumBST(root5, 1, 20)); // Expected: 70 (3 + 5 + 7 + 10 + 12 + 15 + 18)
    }
}

