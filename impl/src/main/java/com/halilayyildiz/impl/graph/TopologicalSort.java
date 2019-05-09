package com.halilayyildiz.impl.graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 5);

        System.out.println("Iterative : " + new TopologicalSort().iterative(g));
        System.out.println("Recursive : " + new TopologicalSort().recursive(g));
    }

    private List<Integer> iterative(Graph g) {
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[g.v];

        // start with the vertices that has no incoming edges
        int[] hasIncoming = new int[g.v];
        for (int i = 0; i < g.v; i++) {
            for (Integer w : g.adj[i]) {
                hasIncoming[w] = 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.v; i++) {
            if (hasIncoming[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            visited[v] = 1;
            res.add(v);

            for (Integer w : g.adj[v]) {
                if (visited[w] == 0)
                    q.add(w);
            }
        }

        return res;
    }

    private List<Integer> recursive(Graph g) {
        // use stack or deque as stack
        Deque<Integer> dq = new LinkedList<>();

        int[] visited = new int[g.v];
        for (int i = 0; i < g.v; i++) {
            if (visited[i] == 0)
                dfs(g, i, visited, dq);
        }

        return new ArrayList<>(dq);
    }

    private void dfs(Graph g, int v, int[] visited, Deque<Integer> dq) {
        visited[v] = 1;
        for (Integer w : g.adj[v]) {
            if (visited[w] == 0)
                dfs(g, w, visited, dq);
        }
        dq.offerFirst(v);
    }
}