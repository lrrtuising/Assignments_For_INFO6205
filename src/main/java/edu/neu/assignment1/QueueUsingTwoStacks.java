package edu.neu.assignment1;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Stack;

/**
 *
 * @author Purvam Sheth
 */

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // INITIALIZE TWO STACKS HERE!!
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        // WRITE YOUR CODE HERE!!!
        stack1.push(x);
    }

    public int dequeue() {
        // WRITE YOUR CODE HERE!!!
        if (stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); // UPDATE THE RETURN STATEMENT ALSO!!
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        // SAMPLE CASE 1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // EXPECTED RESULT 1
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // EXPECTED RESULT 2
        
        // ADD YOUR TEST CASES HERE!!!
        System.out.println(queue.dequeue()); // EXPECTED RESULT 3
        System.out.println(queue.dequeue()); // EXPECTED RESULT 4
        queue.enqueue(5);
        System.out.println(queue.dequeue()); // EXPECTED RESULT 5
        
    }
}

