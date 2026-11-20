class Solution {
    int[] parent;

    private int rank(int x) {
        return Math.abs(parent[x]);
    }

    private int find(int u) {
        if (parent[u] < 0) return u;
        return parent[u] = find(parent[u]);
    }

    private void join(int u, int v) {
        int up = find(u);
        int vp = find(v);

        if (up == vp) return;

        if (rank(up) > rank(vp)) {
            parent[up] -= rank(vp);
            parent[vp] = up;
        } else {
            parent[vp] -= rank(up);
            parent[up] = vp;
        }
    }

    private int countOfConnectedComponents() {
        int ncc = 0;
        for (int node : parent) {
            if (node < 0) ncc++;
        }

        return ncc;
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }

        return countOfConnectedComponents();
    }
}