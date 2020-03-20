package com.wxy.learn.algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 无向图-邻接表 深度优先遍历
 * @author wangxiayun
 * @since 2020-03-19
 */
public class GraphBfs {
    /**
     * 顶点个数
     */
    private int v;
    private List<Integer> adj[]; // 邻接表

    public GraphBfs(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { //无向图,一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 广度优先遍历
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。
        boolean[] visited = new boolean[v];
        visited[s] = true;

        // queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        // prev用来记录搜索路径。
        int[] prev = new int[v];

        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i=0;i<adj[w].size();i++){
                int q = adj[w].get(i);
                if (!visited[q]){
                    prev[q] = w;
                    if (q==t){
                        print(prev,s,t);
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }


    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        GraphBfs graph = new GraphBfs(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.bfs(0,7);

        // 深度优先
        //graph.dfs(0, 6);
    }
}
