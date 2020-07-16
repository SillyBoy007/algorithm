package com.wxy.learn.practice.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的广度优先
 * @author wxy
 * @since 2020-07-11
 */
public class GraphBfs {

    /**
     * 顶点个数
     */
    private int v;

    private List<Integer>[] adj; //领接表


    public GraphBfs(int v){
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i <v ; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    /**
     * 添加边
     * @param s
     * @param t
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }


    public void bfs(int s,int t){
        if (s == t){
            return;
        }

        boolean[] visited = new boolean[v];//记录访问过的节点，避免重复访问
        visited[s] = true;

        // queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);

        int[] prev = new int[v];

        for (int i = 0; i <v ; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0){
            Integer w = queue.poll();

            for (int i = 0; i < adj[w].size();i++) {
                Integer q = adj[w].get(i);
                if (!visited[q]){
                    prev[q] = w;
                    if (q == t){
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }

            }
        }

    }



}
