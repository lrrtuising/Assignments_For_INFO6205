package edu.neu.assignment4;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.PriorityQueue;

/**
 * @author purvamsheth
 */
public class Problem1 {

    // Implement this function!!!
    public void heapSort(int[] arr) {
        // write your code here!!!!
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }


    // Utility function to print an array
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1 hs = new Problem1();
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Unsorted array:");
        hs.printArray(arr);

        hs.heapSort(arr);

        System.out.println("Sorted array:");
        hs.printArray(arr);

        int[] arr2 = {5, 1, 1, 2, 0, 0};
        System.out.println("Unsorted array:");
        hs.printArray(arr2);
        hs.heapSort(arr2);
        System.out.println("Sorted array:");
        hs.printArray(arr2);
    }
}

