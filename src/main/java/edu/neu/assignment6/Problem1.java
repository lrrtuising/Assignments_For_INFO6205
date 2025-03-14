package edu.neu.assignment6;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
import java.util.*;

public class Problem1 {
    
    // Implement the below function!!!
    public List<List<String>> groupAnagrams(String[] strs) {
        //
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for(int num: count){
                keyBuilder.append(num).append("#");
            }
            String key = keyBuilder.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values()); // update return type aswell!
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

