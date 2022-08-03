package com.algs.graph.model.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalConnectionsInNetwork {

   private Map<Integer, Set<Integer>> graph = new HashMap<>();

   private Set<Integer> visited = new HashSet<>();

   private Set<String> resultSet = new HashSet<>();

   private Set<String> treeEdges = new HashSet<>();

   private List<List<Integer>> result = new ArrayList<>();

   private Map<Integer, Integer> arrivalTimes = new HashMap<>();

   int counter = 0;

   public static void main2(String[] args) {

      int[] ints = new int[]{0, 1};

      Set<int[]> treeEdges = new HashSet<>();

      treeEdges.add(ints);

      System.out.println(treeEdges.contains(ints));
   }

   public static void main(String[] args) {

      CriticalConnectionsInNetwork alg = new CriticalConnectionsInNetwork();

      // [[0,1],[1,2],[2,0],[1,3]]
//      int nodes = 4;
//      List<List<Integer>> connections = new LinkedList<>();
//      connections.add(Arrays.asList(0, 1));
//      connections.add(Arrays.asList(1, 2));
//      connections.add(Arrays.asList(2, 0));
//      connections.add(Arrays.asList(1, 3));


      // [[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
      int nodes = 5;
      List<List<Integer>> connections = new LinkedList<>();
      connections.add(Arrays.asList(1, 0));
      connections.add(Arrays.asList(2, 0));
      connections.add(Arrays.asList(3, 2));
      connections.add(Arrays.asList(4, 2));
      connections.add(Arrays.asList(4, 3));
      connections.add(Arrays.asList(3, 0));
      connections.add(Arrays.asList(4, 0));

      List<List<Integer>> bridges = alg.criticalConnections(nodes, connections);

      for (List<Integer> bridge : bridges) {
         System.out.println("(" + bridge.get(0) + ", " + bridge.get(1) + ")");
      }
   }

   public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

      for (List<Integer> edge : connections) {
         int source = edge.get(0);
         int destination = edge.get(1);

         if (!graph.containsKey(source)) {
            graph.put(source, new HashSet<>());
         }
         if (!graph.containsKey(destination)) {
            graph.put(destination, new HashSet<>());
         }

         graph.get(source).add(destination);
         graph.get(destination).add(source);
      }

      twoEdgeConnected(0);

      return result;
   }

   private int twoEdgeConnected(int node) {
      arrivalTimes.put(node, counter++);
      visited.add(node);

      Set<Integer> adj = graph.get(node);

      int dbe = arrivalTimes.get(node);

      if (adj != null) {
         for (int w : adj) {
            if (!visited.contains(w)) {

               treeEdges.add(node + "-" + w);

               int wdbe = twoEdgeConnected(w);
               if (wdbe > arrivalTimes.get(node)) {
                  // found a bridge
                  if (!(resultSet.contains(node + "-" + w) || resultSet.contains(w + "-" + node))) {
                     result.add(Arrays.asList(node, w));
                     resultSet.add(node + "-" + w);
                  }
               }

               dbe = Math.min(dbe, wdbe);

            } else if (!(treeEdges.contains(node + "-" + w) || treeEdges.contains(w + "-" + node))) {
               dbe = Math.min(dbe, arrivalTimes.get(w));
            }
         }
      }

      return dbe;
   }

}
