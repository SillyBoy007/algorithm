package com.wxy.learn.algorithm.graph;

import java.util.LinkedList;

/**
 *  图遍历-深度优先
 * @author wangxiayun
 * @since 2020-03-20
 */
public class GraphDfs {
    private int v;
    private boolean found = false;
    private LinkedList<Integer> adj[]; // 邻接表

    public GraphDfs(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
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


    public void dfs(int s,int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i=0;i<v;i++){
            prev[i] = -1;
        }

        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }



    private void recurDfs(int w,int t,boolean[] visited,int[] prev){
        if (found){
            return;
        }
        visited[w] = true;
        if (w == t){
            found = true;
            return;
        }

        for (int i=0;i<adj[w].size();i++){
            int q = adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }

    }


    public static void main(String[] args) {
        GraphDfs graph = new GraphDfs(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.dfs(0,7);
    }

}
