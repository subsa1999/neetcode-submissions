class Solution {
    int[] parent;
    int components;

    private int _size(int x) {
        return Math.abs(parent[x]);
    }

    private int _find(int u) {
        if (parent[u] < 0) return u;
        return parent[u] = _find(parent[u]);
    }

    private void _join(int u, int v) {
        int up = _find(u);
        int vp = _find(v);

        if (up == vp) return;

        if (_size(up) > _size(vp)) {
            parent[up] -= _size(vp);
            parent[vp] = up;
        } else {
            parent[vp] -= _size(up);
            parent[up] = vp;
        }

        components--;
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        components = n;

        for (int[] edge : edges) {
            _join(edge[0], edge[1]);
        }

        return components;
    }
}