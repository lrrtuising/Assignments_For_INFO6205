package edu.neu.assignment5;/*
                            * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
                            * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
                            */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author purvamsheth
 */

public class Problem2 {
    private TreeNode prev;
    // Implement the below function
    public TreeNode increasingBST(TreeNode root) {

        TreeNode dummy = new TreeNode(-1);
        prev = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        root.left = null;
        prev.right = root;
        prev = root;

        inorder(root.right);
    }

    // Helper function to print the tree (for verification)
    public void printTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        // Test Case 1: A BST to be rearranged
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println("Case 1: ");
        System.out.println("Original Tree (In-Order Traversal): ");
        solution.printTreeInOrder(root1);

        TreeNode newRoot1 = solution.increasingBST(root1);

        System.out.println("");
        System.out.println("Rearranged Tree (In-Order Traversal): ");
        solution.printTreeInOrder(newRoot1);
        System.out.println("");

        // you can also implement InOrder and LevelOrder Traversal for verification
        // purpose!!

    // Test Case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        root2.right.right = new TreeNode(8);
        root2.right.right.left = new TreeNode(7);
        root2.right.right.right = new TreeNode(9);

        System.out.println("Case 2: ");
        System.out.println("Original Tree (In-Order Traversal): ");
        solution.printTreeInOrder(root2);

        TreeNode newRoot2 = solution.increasingBST(root2);

        System.out.println("");
        System.out.println("Rearranged Tree (In-Order Traversal): ");
        solution.printTreeInOrder(newRoot2);
        System.out.println("");
    }
}
