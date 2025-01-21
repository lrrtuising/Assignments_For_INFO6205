package edu.neu.assignment2;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author purvamsheth
 */
public class Problem3 {
    public static void main(String[] args) {
        int n = 32;
        int count = 0;
        while (n > 1) {
            n /= 2;
            count++;
        }
        System.out.println("Iterations: " + count);
    } 
}

