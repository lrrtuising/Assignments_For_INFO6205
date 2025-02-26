package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rushdi
 */
//class TreeNode {
//    int val;
//    TreeNode left, right;
//    TreeNode(int val) { this.val = val; }
//}

public class Problem3_solution {
    private static int count = 0;
    private static int result = 0;
    
    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return result;
    }

    private static void inorderTraversal(TreeNode node) {
        if (node == null || count == 0) return;
        
        inorderTraversal(node.left); // Visit left subtree
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }
        inorderTraversal(node.right); // Visit right subtree
    }

    // Helper method to insert nodes into the BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Helper method to build BST from array
    public static TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }
        return root;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] values1 = {3, 1, 4, 2};
        TreeNode root1 = buildBST(values1);
        int k1 = 1;
        System.out.println("Kth Smallest (k=1): " + kthSmallest(root1, k1)); // Output: 1
        
        // Test case 2
        int[] values2 = {5, 3, 6, 2, 4, 1};
        TreeNode root2 = buildBST(values2);
        int k2 = 3;
        System.out.println("Kth Smallest (k=3): " + kthSmallest(root2, k2)); // Output: 3
        
        // Test case 3
        int[] values3 = {7, 4, 9, 2, 5, 8, 10, 1, 3};
        TreeNode root3 = buildBST(values3);
        int k3 = 5;
        System.out.println("Kth Smallest (k=5): " + kthSmallest(root3, k3)); // Output: 5
    }
}

