package com.algs.graph.model.bfs;

import com.algs.graph.model.Edge;
import com.algs.graph.model.Graph;
import com.algs.graph.model.Vertex;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

   public static void main(String[] args) {
      BFS bfs = new BFS();
      bfs.test();
   }


   public void test() {

      Graph<Attributes> graph = new Graph<>(false);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(3, 5);
      graph.addEdge(3, 6);
      graph.addEdge(4, 7);
      graph.addEdge(5, 8);
      graph.addEdge(5, 9);
      graph.addEdge(9, 10);

      bfs(graph, graph.getVertex(10));

      System.out.println(graph);

      printToTarget(graph, 10, 7);
   }

   public void bfs(Graph<Attributes> graph, Vertex<Attributes> source) {

      Set<Vertex> visited = new HashSet<>();

      Queue<Vertex> queue = new LinkedList<>();

      ensureDataInitialized(source);
      source.getData().setDistance(0);

      queue.add(source);

      while (!queue.isEmpty()) {

         Vertex<Attributes> target = queue.poll();

         List<Edge<Attributes>> edges = target.getEdges();

         for (Edge edge : edges) {
            Vertex<Attributes> vertex = edge.getTo();
            if (!visited.contains(vertex) && !queue.contains(vertex)) {
               ensureDataInitialized(vertex);
               vertex.getData().setDistance(target.getData().getDistance() + 1);
               vertex.getData().setParent(target.getId());
               queue.add(vertex);
            }
         }

         visited.add(target);
      }

   }

   private void printToTarget(Graph<Attributes> graph, int source, int target){

      Vertex<Attributes> sourceVertex = graph.getVertex(source);

      Vertex<Attributes> targetVertex = graph.getVertex(target);

      if (targetVertex.getData().getParent() == 0) {
         return;
      }

      Vertex<Attributes> vertex = targetVertex;

      while(vertex.getData().getParent() != 0){
         System.out.print(vertex.getId() + " -> ");
         vertex = graph.getVertex(vertex.getData().getParent());
      }

      System.out.print(sourceVertex.getId());
   }

   private void ensureDataInitialized(Vertex vertex) {
      if (vertex.getData() == null) {
         vertex.setData(new Attributes());
      }
   }


   private class Attributes {

      private int distance;

      private int parent;

      public void setDistance(int distance) {
         this.distance = distance;
      }

      public int getDistance() {
         return distance;
      }

      public void setParent(int parent) {
         this.parent = parent;
      }

      public int getParent() {
         return parent;
      }
   }


}
