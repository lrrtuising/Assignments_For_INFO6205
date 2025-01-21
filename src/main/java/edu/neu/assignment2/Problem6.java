package edu.neu.assignment2;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
public class Problem6 {
    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode solution(ListNode head, int n) {
        // WRITE YOUR CODE HERE
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode fast = temp;
        ListNode slow = temp;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return temp.next; // UPDATE THIS LINE OF CODE ALSO!!!
    }

    // HELPER FUNCTION TO PRINT THE LINKEDLIST
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // Example: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int n = 2;
        
        head = solution(head, n);

        System.out.print("Updated List: ");
        printList(head); // EXPECTED RESULT 1->2->3->5
        
        
        // ADD YOUR TEST CASES HERE!!!!

        // Example2: 1 -> 2, n = 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.print("Original List 2: ");
        printList(head2);

        int n2 = 2;

        head2 = solution(head2, n2);

        System.out.print("Updated List 2: ");
        printList(head2); // EXPECTED RESULT 2

    }

    
}
