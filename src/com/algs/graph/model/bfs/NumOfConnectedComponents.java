package com.algs.graph.model.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumOfConnectedComponents {

   public static void main(String[] args) {
      NumOfConnectedComponents cc = new NumOfConnectedComponents();

      int n = 5;
      int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};

      System.out.println(cc.components(5, new int[][]{{0, 1}, {1, 2}, {3, 4}})); // ans: 2

      System.out.println(cc.components(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}})); // ans: 1


//      int[] parent = new int[] {0, 1, 3, 7, 4, 5, 6, 0};
//      int parent1 = cc.findParent(parent, 2);
//      System.out.println(parent1);
   }


   public int components(int n, int[][] edges) {
      if (edges == null || edges.length == 0) return n;

      Map<Integer, List<Integer>> graph = new HashMap<>();

      for (int[] edge : edges) {
         List<Integer> adj1 = graph.getOrDefault(edge[0], new LinkedList<>());
         adj1.add(edge[1]);
         graph.put(edge[0], adj1);

         List<Integer> adj2 = graph.getOrDefault(edge[1], new LinkedList<>());
         adj2.add(edge[0]);
         graph.put(edge[1], adj2);
      }

      int components = 0;

      Set<Integer> visited = new HashSet<>();
      for (int i = 0; i < n; i++) {
         if (visited.contains(i)) continue;

         components++;

         dfs(i, graph, visited);
      }

      return components;
   }

   private void dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
      visited.add(i);
      List<Integer> adjNodes = graph.getOrDefault(i, Collections.emptyList());
      for (Integer adj : adjNodes) {
         if (!visited.contains(adj)) {
            dfs(adj, graph, visited);
         }
      }
   }

}
