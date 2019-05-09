package com.halilayyildiz.impl.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    int v;
    List<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}