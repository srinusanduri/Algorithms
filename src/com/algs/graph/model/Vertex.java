package com.algs.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

   private int id;

   private T data;

   private List<Vertex<T>> adjacentVertices = new ArrayList<>();

   private List<Edge<T>> edges = new ArrayList<>();

   public Vertex(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setData(T data) {
      this.data = data;
   }

   public T getData() {
      return data;
   }

   public void addEdge(Edge<T> edge) {
      edges.add(edge);
   }

   public List<Edge<T>> getEdges() {
      return edges;
   }
}
