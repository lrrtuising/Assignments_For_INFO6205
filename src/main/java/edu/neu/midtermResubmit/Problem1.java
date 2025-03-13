package edu.neu.midtermResubmit;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Problem1 {

    // IMPLEMENT THE BELOW FUNCTION!
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }

        char[] arr = word.toCharArray();
        int left = 0, right = index;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        // update return statement as well!
        return new String(arr);
    }

    // Main method to run some test cases
    public static void main(String[] args) {
        // Test case 1
        String word1 = "abcdefd";
        char ch1 = 'd';
        System.out.println(reversePrefix(word1, ch1)); // Output: "dcbaefd"

        // Test case 2
        String word2 = "xyxzxe";
        char ch2 = 'z';
        System.out.println(reversePrefix(word2, ch2)); // Output: "zxyxxe"

        // Test case 3
        String word3 = "abcd";
        char ch3 = 'z';
        System.out.println(reversePrefix(word3, ch3)); // Output: "abcd"

        // If needed add additional test cases here!!


    }
}

