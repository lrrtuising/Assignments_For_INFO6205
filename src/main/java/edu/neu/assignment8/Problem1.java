package edu.neu.assignment8;

/**
 * @author name
 */
class Problem1 {

    // Implement the below function!!!
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount(); // Update the return statement aswell!!!
    }


    // Main method with test cases
    public static void main(String[] args) {
        Problem1 solution = new Problem1();

        // Test Case 1
        int[][] isConnected1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println("Test Case 1:");
        System.out.println("Input: [[1,1,0],[1,1,0],[0,0,1]]");
        System.out.println("Result: " + solution.findCircleNum(isConnected1));

        // Test Case 2
        int[][] isConnected2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: [[1,0,0],[0,1,0],[0,0,1]]");
        System.out.println("Result: " + solution.findCircleNum(isConnected2));
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
