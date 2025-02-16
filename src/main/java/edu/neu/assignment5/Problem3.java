package edu.neu.assignment5;/*
                            * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
                            * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
                            */

import java.util.*;

/**
 *
 * @author purvamsheth
 */

public class Problem3 {

    // implement the below function!!!
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int index = left + 1;
        while (index <= right && preorder[index] <= root.val) {
            index++;
        }
        root.left = construct(preorder, left + 1, index - 1);
        root.right = construct(preorder, index, right);
        return root;
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
        Problem3 solution = new Problem3();

        // Test Case 1
        int[] preorder1 = { 8, 5, 1, 7, 10, 12 };
        TreeNode root1 = solution.bstFromPreorder(preorder1);

        System.out.println("Tree from Preorder (Test Case 1): ");
        solution.printTreeInOrder(root1);

        // Test Case 2
        int[] preorder2 = { 1, 3 };
        Problem3 solution1 = new Problem3();
        TreeNode root2 = solution1.bstFromPreorder(preorder2);

        System.out.println("\nTree from Preorder (Test Case 2): ");
        solution1.printTreeInOrder(root2);

        // You can implement level order traversal for verification
    }
}
