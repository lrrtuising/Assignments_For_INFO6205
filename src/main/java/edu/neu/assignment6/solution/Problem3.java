package edu.neu.assignment6.solution;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author purvamsheth
 */
public class Problem3 {

    // Define the array size for the hash map.
    private static final int SIZE = 1000;
    
    // The bucket array
    private Entry[] map;

    // Constructor to initialize the hash map
    public Problem3() {
        map = new Entry[SIZE];
    }

    // Define the Entry class to store key-value pairs in the hash map
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Hash function to get index for a given key
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Put a key-value pair into the map
    public void put(int key, int value) {
        int index = getIndex(key);
        if (map[index] == null) {
            map[index] = new Entry(key, value);
        } else {
            Entry current = map[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value; // Update the value if key is found
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Entry(key, value); // Insert the new key-value pair at the end of the chain
        }
    }

    // Get the value associated with a key
    public int get(int key) {
        int index = getIndex(key);
        Entry current = map[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1; // Return -1 if the key doesn't exist
    }

    // Remove the key-value pair from the map
    public void remove(int key) {
        int index = getIndex(key);
        Entry current = map[index];
        Entry previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    map[index] = current.next; // Remove the first element in the chain
                } else {
                    previous.next = current.next; // Remove the element in the chain
                }
                return;
            }
            previous = current;
            current = current.next;
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

