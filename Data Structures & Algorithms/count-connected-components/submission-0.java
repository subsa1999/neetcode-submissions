class Solution {
    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = 1;
        }

        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                continue;
            }
            connectedComponents++;
            dfs(graph, i, -1, visited);
        }

        return connectedComponents;
    }

    void dfs(int[][] graph, int node, int parent, boolean[] visited) {
        if (!valid(graph, node)) {
            return;
        }

        if (visited[node]) {
            return;
        }

        visited[node] = true;
        
        for (int nextNode = 0; nextNode < graph[node].length; ++nextNode) {
            if (nextNode != parent && graph[node][nextNode] == 1) {
                dfs(graph, nextNode, node, visited);
            }
        }
    }

    boolean valid(int[][] graph, int node) {
        return 0 <= node && node < graph.length;
    }
}
