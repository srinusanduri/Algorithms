package com.algs.graph.model;

public class Edge<T> {

   private int weight;

   private Vertex<T> from;

   private Vertex<T> to;

   public Edge(Vertex<T> from, Vertex<T> to, int weight) {
      this.weight = weight;
      this.from = from;
      this.to = to;
   }

   public Edge(Vertex<T> from, Vertex<T> to) {
      this(from, to, 1);
   }

   public int getWeight() {
      return weight;
   }

   public Vertex getFrom() {
      return from;
   }

   public Vertex getTo() {
      return to;
   }

   @Override
   public String toString() {
      return "(" + from.getId() + ", " + to.getId() + ")";
   }
}
