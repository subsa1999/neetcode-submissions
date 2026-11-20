class Solution {
    private List<Integer>[] graph;
    private boolean[] seen;
    private boolean cycleExists;

    public boolean validTree(int n, int[][] edges) {
        graph = new List[n];

        for (int i = 0; i < n; ++i) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        seen = new boolean[n];

        DFS(-1, 0);

        // check if no cycle?
        if (cycleExists) return false;

        // check all are connected?
        for (int i = 0; i < n; ++i) {
            if (!seen[i]) return false;
        }

        return true;
    }

    private void DFS(int parent, int node) {
        if (seen[node]) {
            cycleExists = true;
            return;
        }

        seen[node] = true;
        for (int next : graph[node]) {
            if (next != parent) {
                DFS(node, next);
            }
        }
    }
}
