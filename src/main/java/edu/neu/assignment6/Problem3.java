package edu.neu.assignment6;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;

/**
 * @author
 */
public class Problem3 {

    // Implement constructor, put, get, remove methods!
    private static final int SIZE = 1000;
    private Node[] buckets;

    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Problem3() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        Node prev = null;
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;
        while(curr != null) {
            if(curr.key == key) {
                if(prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Main method to test the MyHashMap class
    public static void main(String[] args) {
        Problem3 myHashMap = new Problem3();

        // Test case operations
        myHashMap.put(1, 1);         // The map is now [[1,1]]
        myHashMap.put(2, 2);         // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // return 1
        System.out.println(myHashMap.get(3)); // return -1
        myHashMap.put(2, 1);         // The map is now [[1,1], [2,1]] (update value for key 2)
        System.out.println(myHashMap.get(2)); // return 1
        myHashMap.remove(2);         // The map is now [[1,1]]
        System.out.println(myHashMap.get(2)); // return -1 (key 2 is removed)
    }
}

