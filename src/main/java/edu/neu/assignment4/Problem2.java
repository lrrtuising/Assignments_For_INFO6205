package edu.neu.assignment4;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
import java.awt.List;
import java.util.*;

public class Problem2 {
    
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    // IMPLEMENT THE BELOW FUNCTION
    public ListNode mergeKLists(ListNode[] lists) {
        // WRITE YOUR CODE HERE!!!
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next; // UPDATE THIS RETURN STATEMENT ALSO
    }

    // Helper method to create a linked list from an array
    public ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem2 solution = new Problem2();
        
        // Create some test linked lists
        ListNode list1 = solution.createLinkedList(new int[]{1, 4, 5});
        ListNode list2 = solution.createLinkedList(new int[]{1, 3, 4});
        ListNode list3 = solution.createLinkedList(new int[]{2, 6});
        
        // Combine lists into an array
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        
        // Merge the k sorted lists
        ListNode mergedList = solution.mergeKLists(lists);
        
        // Print the merged list
        System.out.print("Merged List: ");
        solution.printList(mergedList);

        // Input: lists = [[]]
        ListNode listnode2 = solution.createLinkedList(new int[]{});
        ListNode[] lists2 = new ListNode[]{listnode2};
        ListNode mergedList2 = solution.mergeKLists(lists2);
        System.out.print("Merged List2: ");
        solution.printList(mergedList2);
    }
}

