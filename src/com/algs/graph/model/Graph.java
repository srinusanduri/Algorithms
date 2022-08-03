package com.algs.graph.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

   private boolean isDirected;

   private List<Vertex<T>> vertices = new ArrayList<>();

   private Map<Integer, Vertex<T>> verticesMap = new HashMap<>();

   public Graph() {
   }

   public Graph(boolean isDirected) {
      this.isDirected = isDirected;
   }

   public void addVertex(int id) {
      addVertex(new Vertex<>(id));
   }

   public void addVertex(Vertex<T> vertex) {
      vertices.add(vertex);
      verticesMap.put(vertex.getId(), vertex);
   }

   public Vertex getVertex(int id) {
      return verticesMap.get(id);
   }

   public void addEdge(int vertex1Id, int vertex2Id) {
      addEdge(vertex1Id, vertex2Id, 1);
   }

   public void addEdge(int vertex1Id, int vertex2Id, int weight) {

      Vertex<T> vertex1 = handleVertexCreation(vertex1Id);
      Vertex<T> vertex2 = handleVertexCreation(vertex2Id);

      Edge<T> edge = new Edge(vertex1, vertex2, weight);

      vertex1.addEdge(edge);

      if (!isDirected) {
         Edge<T> oppositeEdge = new Edge(vertex2, vertex1, weight);
         vertex2.addEdge(oppositeEdge);
      }

   }

   private Vertex<T> handleVertexCreation(int id) {
      Vertex<T> vertex = verticesMap.get(id);
      if (vertex == null) {
         vertex = new Vertex(id);
         vertices.add(vertex);
         verticesMap.put(id, vertex);
      }
      return vertex;
   }

}
