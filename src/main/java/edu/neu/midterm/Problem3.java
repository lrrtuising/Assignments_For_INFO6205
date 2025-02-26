package edu.neu.midterm;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem3 {
    // IMPLEMENT BELOW FUNCTION!!
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (checkPath(head, root)) return true;

        // update return statement as well!
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val) {
            return checkPath(head.next, root.left) || checkPath(head.next, root.right);
        }
        return false;
    }


    public static void main(String[] args) {

        Problem3 solution = new Problem3();
        // Test case 1
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(8))); // 4->2->8
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(1);
        root1.right.left = new TreeNode(2);
        root1.right.left.left = new TreeNode(6);
        root1.right.left.right = new TreeNode(8);
        root1.right.left.right.left = new TreeNode(1);
        root1.right.left.right.right = new TreeNode(3);
        // Root1: Level Order Traversal: [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]

        System.out.println(solution.isSubPath(head1, root1)); // Expected Output: true

        // Test case 2
        ListNode head2 = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6)))); // 1->4->2->6
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(1);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(6);
        root2.right.left.right = new TreeNode(8);
        root2.right.left.right.left = new TreeNode(1);
        root2.right.left.right.right = new TreeNode(3);
        // Root2: Level Order Traversal: [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]

        System.out.println(solution.isSubPath(head2, root2)); // Expected Output: true

        // Test case 3
        ListNode head3 = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6, new ListNode(8))))); // 1->4->2->6->8
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(4);
        root3.left.right = new TreeNode(2);
        root3.left.right.left = new TreeNode(1);
        root3.right.left = new TreeNode(2);
        root3.right.left.left = new TreeNode(6);
        root3.right.left.right = new TreeNode(8);
        root3.right.left.right.left = new TreeNode(1);
        root3.right.left.right.right = new TreeNode(3);
        // Root3: Level Order Traversal: [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]

        System.out.println(solution.isSubPath(head3, root3)); // Expected Output: false
    }
}
