package edu.neu.finalExam;

public class problem3 {

    // IMPLEMENT THE BELOW FUNCTION!!
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[0] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || minDist[v] < minDist[u])) {
                    u = v;
                }
            }
            visited[u] = true;
            res += minDist[u];
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (cost < minDist[v]) minDist[v] = cost;
                }
            }
        }
        return res;
    }


    // Edge class to represent connections between points
    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        problem3 solution = new problem3();

        // Test case 1
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int result1 = solution.minCostConnectPoints(points1);
        System.out.println("Test case 1: " + result1); // Expected: 20

        // Test case 2
        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        int result2 = solution.minCostConnectPoints(points2);
        System.out.println("Test case 2: " + result2); // Expected: 18

    }
}
