package com.halilayyildiz.impl.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.halilayyildiz.impl.graph.GraphWeighted.*;

public class MinimumSpanningTree {

    public static void main(String[] args) {

        GraphWeighted g = new GraphWeighted(6);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);

        print(new MinimumSpanningTree().kruskalsMST(g));
    }


    private List<Edge> kruskalsMST(GraphWeighted g) {
        List<Edge> res = new ArrayList<>();
        UnionFind uf = new UnionFind(g.v);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (List<Edge> edges : g.adj) {
            for (Edge e : edges) {
                pq.add(e);
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (uf.find(edge.from) != uf.find(edge.to)) {
                res.add(edge);
                uf.union(edge.from, edge.to);
            }
        }

        return res;
    }

    private static void print(List<Edge> edges) {
        Collections.sort(edges, (a, b) -> a.from == b.from ? a.to - b.to : a.from - b.from);
        edges.stream().forEach(e -> System.out.println("Edge: " + e.from + " -> " + e.to + " | " + e.weight));
    }

}