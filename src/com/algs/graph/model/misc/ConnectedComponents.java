package com.algs.graph.model.misc;

/*
   Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
   write a function to find the number of connected components in an undirected graph.

   For example: Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 */
public class ConnectedComponents {

   public static void main(String[] args) {
      ConnectedComponents cc = new ConnectedComponents();

      int n = 5;
      int[][] edges = new int[][] {{0, 1}, {1, 2}, {3, 4}};

      int connectedComponents = cc.numOfConnectedComponents(n, edges);

      System.out.println(connectedComponents);

//      int[] parent = new int[] {0, 1, 3, 7, 4, 5, 6, 0};
//      int parent1 = cc.findParent(parent, 2);
//      System.out.println(parent1);
   }

   public int numOfConnectedComponents(int n, int[][] edges) {
      int connectedComponents = n;

      if (edges == null || edges.length == 0) {
         return connectedComponents;
      }

      int[] parent = new int[n];
      for (int i = 0; i < n; i++) {
         parent[i] = i;
      }

      for (int[] edge : edges) {
         int src = edge[0];
         int dest = edge[1];

         int srcP = findParent(parent, src);
         int destP = findParent(parent, dest);

         if (srcP != destP) {
            parent[destP] = srcP;
            connectedComponents--;
         }
      }

      return connectedComponents;
   }

   public int findParent(int[] parent, int node) {
      while (parent[node] != node) {
         //System.out.println("node: " + node + ", before parent: " + parent[node]);
         parent[node] = parent[parent[node]];
         //System.out.println("node: " + node + ", after parent: " + parent[node]);
         node = parent[node];
         //System.out.println("reset node: " + node);
      }
      return parent[node];
   }

}
