package edu.neu.assignment3;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem3 {

  // IMPLEMENT THE BELOW FUNCTION!!
  public static ListNode sortList(ListNode head) {
    // WRITE YOUR CODE HERE
    if (head == null || head.next == null) {
        return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    ListNode right = slow.next;
    slow.next = null;

    ListNode left = sortList(head);
    right = sortList(right);

    return merge(left, right); // UPDATE THE RETURN STATEMENT ALSO!!
  }

  private static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    
    curr.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}


    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        // Sort the linked list
        ListNode sortedHead = sortList(head);

        System.out.println("Sorted List:");
        printList(sortedHead); // Expected output: 1 2 3 4


        // Example input: -1 -> 5 -> 3 -> 4 -> 0
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        System.out.println("Original List:");
        printList(head2);
        
        // Sort the linked list
        ListNode sortedHead2 = sortList(head2);
        
        System.out.println("Sorted List:");
        printList(sortedHead2); // Expected output: -1 0 3 4 5



        // Example input: []
        ListNode head3 = new ListNode();


        System.out.println("Original List:");
        printList(head3);
        
        // Sort the linked list
        ListNode sortedHead3 = sortList(head3);
        
        System.out.println("Sorted List:");
        printList(sortedHead3); // Expected output: []
        
    }
}

