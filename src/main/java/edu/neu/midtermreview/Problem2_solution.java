package edu.neu.midtermreview;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rushdi
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
public class Problem2_solution {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head for result list
        ListNode current = dummyHead;
        int carry = 0;
        
        // Iterate while either list has elements or there is a carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with carry from previous iteration
            
            if (l1 != null) {
                sum += l1.val; // Add l1's value
                l1 = l1.next; // Move to next node
            }
            
            if (l2 != null) {
                sum += l2.val; // Add l2's value
                l2 = l2.next; // Move to next node
            }
            
            carry = sum / 10; // Compute carry for next iteration
            current.next = new ListNode(sum % 10); // Store last digit in new node
            current = current.next;
        }
        
        return dummyHead.next; // Return result list, skipping dummy head
    }

    // Helper method to create linked list from array
    public static ListNode createLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

    // Helper method to print linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = createLinkedList(arr1);
        ListNode l2 = createLinkedList(arr2);
        System.out.print("Input: "); printLinkedList(l1); printLinkedList(l2);
        System.out.print("Output: "); printLinkedList(addTwoNumbers(l1, l2));
        
        int[] arr3 = {0};
        int[] arr4 = {0};
        ListNode l3 = createLinkedList(arr3);
        ListNode l4 = createLinkedList(arr4);
        System.out.print("Input: "); printLinkedList(l3); printLinkedList(l4);
        System.out.print("Output: "); printLinkedList(addTwoNumbers(l3, l4));
        
        int[] arr5 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr6 = {9, 9, 9, 9};
        ListNode l5 = createLinkedList(arr5);
        ListNode l6 = createLinkedList(arr6);
        System.out.print("Input: "); printLinkedList(l5); printLinkedList(l6);
        System.out.print("Output: "); printLinkedList(addTwoNumbers(l5, l6));
    }
}

