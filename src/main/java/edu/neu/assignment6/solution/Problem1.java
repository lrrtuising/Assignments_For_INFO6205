package edu.neu.assignment6.solution;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */

import java.util.*;

public class Problem1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to store lists of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a character array, then sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // Convert the sorted character array back to a string (key)
            String sortedStr = new String(charArray);

            // If the key does not exist in the map, create a new list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // Add the original string to the list corresponding to the sorted key
            map.get(sortedStr).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Problem1 ga = new Problem1();

        // Test case 1
        String[] testCase1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test case 1: " + ga.groupAnagrams(testCase1));

        // Test case 2
        String[] testCase2 = {""};
        System.out.println("Test case 2: " + ga.groupAnagrams(testCase2));

        // Test case 3
        String[] testCase3 = {"a"};
        System.out.println("Test case 3: " + ga.groupAnagrams(testCase3));
    }
}

