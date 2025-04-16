package edu.neu.finalExam;

public class problem2 {
    // IMPLEMENT THE BELOW FUNCTION!!
    public int[] findRedundantConnection(int[][] edges) {        
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu == pv) return edge;
            parent[pu] = pv;
        }
        return new int[2];
    }
    
    // Find operation with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    public static void main(String[] args) {
        problem2 solution = new problem2();
        
        // Test case 1
        int[][] edges1 = {{1,2}, {1,3}, {2,3}};
        int[] result1 = solution.findRedundantConnection(edges1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [2, 3]
        
        // Test case 2
        int[][] edges2 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] result2 = solution.findRedundantConnection(edges2);
        System.out.println("Test case 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 4]
    }
}
