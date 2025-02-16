package edu.neu.assignment5;

/**
 *
 * @author purvamsheth
 */
public class Problem4 {

    // Enum to define color of the node
    enum Color { RED, BLACK }

    // Red-Black Tree Node
    class Node {
        int data;
        Node left, right, parent;
        Color color;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.color = Color.RED;  // New nodes are always red by default
            this.left = this.right = this.parent = null;
        }
    }

    // Root node of the Red-Black Tree
    private Node root;

    public Problem4() {
        root = null;
    }

    // IMPLEMENT THE BELOW FUNCTION
    // Right rotate function
    public void rightRotate(Node x) {
        // WRITE YOUR CODE HERE!!!
        if (x == null || x.left == null) {
            return;
        }
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Utility function to print the tree (In-order traversal)
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
    
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }   

    // Insert function for adding nodes to the tree (to help with testing)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            insertRec(root, newNode);
        }
        // Fix the tree properties here after insertion (not implemented in this demo)
    }

    // Helper function to insert a new node (standard BST insert)
    private void insertRec(Node root, Node newNode) {
        if (newNode.data < root.data) {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else {
                insertRec(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else {
                insertRec(root.right, newNode);
            }
        }
    }

    // Function to print the tree structure
    public void printTree() {
        preOrderTraversal(root);
        System.out.println();
    }

    // Test Cases
    public static void main(String[] args) {
        Problem4 rbt = new Problem4();

        // Test Case 1: Simple Tree before and after rotation
        System.out.println("Test Case 1: Simple Tree");
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(20);
        System.out.println("Tree before rotation:");
        rbt.printTree();  // Expected: 10 5 20 
        rbt.rightRotate(rbt.root);  // Right rotate on the root node
        System.out.println("Tree after right rotation:");
        rbt.printTree();  // Expected: 5 10 20 (rotation on root)

        // Test Case 2: More complex tree
        System.out.println("\nTest Case 2: More complex tree");
        rbt.insert(15);
        rbt.insert(3);
        rbt.insert(18);
        rbt.insert(7);
        rbt.insert(25);
        System.out.println("Tree before rotation:");
        rbt.printTree();  // Expected: 5 3 10 7 20 15 18 25
        rbt.rightRotate(rbt.root.right);  // Right rotate
        System.out.println("Tree after right rotation:");
        rbt.printTree();  // Expected: 5 3 7 10 20 15 18 25

        // Test Case 3: Deep Tree Rotation
        System.out.println("\nTest Case 3: Deep Tree Rotation");
        Problem4 rbt2 = new Problem4();
        rbt2.insert(10);
        rbt2.insert(5);
        rbt2.insert(20);
        rbt2.insert(15);
        rbt2.insert(30);
        rbt2.insert(25);
        rbt2.insert(40);
        rbt2.insert(35);
        rbt2.insert(45);

        System.out.println("Tree before rotation:");
        rbt2.printTree();  // Expected: 10 5 20 15 30 25 40 35 45
        rbt2.rightRotate(rbt2.root.right);  // Right rotate
        System.out.println("Tree after right rotation:");
        rbt2.printTree();  // Expected: 10 5 15 20 30 25 40 35 45 

        // Test Case 4: Rotation at internal node
        System.out.println("\nTest Case 4: Rotation at internal node");
        Problem4 rbt3 = new Problem4();
        rbt3.insert(50);
        rbt3.insert(30);
        rbt3.insert(20);
        rbt3.insert(40);
        rbt3.insert(70);
        rbt3.insert(60);
        rbt3.insert(80);

        System.out.println("Tree before rotation:");
        rbt3.printTree();  // Expected: 50 30 20 40 70 60 80 
        rbt3.rightRotate(rbt3.root.left);  // Right rotate
        System.out.println("Tree after right rotation:");
        rbt3.printTree();  // Expected: 50 20 30 40 70 60 80
    }
}
