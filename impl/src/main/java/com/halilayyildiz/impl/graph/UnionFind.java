package com.halilayyildiz.impl.graph;

public class UnionFind {

    private int[] parent;

    public UnionFind(int size) {
        this.parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        while (parent[u] != u)
            u = parent[u];
        return u;
    }

    public void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u != v) {
            parent[u] = v;
        }
    }
}
