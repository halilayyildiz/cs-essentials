package com.halilayyildiz.impl.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphWeighted {

    public class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    int v;
    List<Edge>[] adj;

    GraphWeighted(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int from, int to, int weight) {
        adj[from].add(new Edge(from, to, weight));
    }
}

