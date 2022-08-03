package com.algs.graph.model.kruskal;

import java.util.Objects;
import javax.sound.midi.Soundbank;

public class UnionFindDriver {

   public static void main(String[] args) {

      Vertex one = new Vertex(1);
      Vertex two = new Vertex(2);
      Vertex three = new Vertex(3);
      Vertex four = new Vertex(4);
      Vertex five = new Vertex(5);

      UnionFind<Vertex> uf = new UnionFind<>();
      uf.add(three);
      uf.add(five);
      uf.add(one);
      uf.add(four);
      uf.add(two);

      Vertex threeCopy = new Vertex(3);
      Vertex vertex = uf.find(threeCopy);

      System.out.println(vertex);

      Vertex fourCopy = new Vertex(4);

      uf.union(uf.find(threeCopy), uf.find(fourCopy));

      uf.union(uf.find(one), uf.find(fourCopy));

      System.out.println(uf.numOfSets());
   }

   static class Vertex {

      int label;

      Vertex(int label) {
         this.label = label;
      }

      public int getLabel() {
         return label;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }
         Vertex vertex = (Vertex) o;
         return label == vertex.label;
      }

      @Override
      public int hashCode() {
         return Objects.hash(label);
      }

      @Override
      public String toString() {
         return "Vertex{" +
               "label=" + label +
               '}';
      }
   }

}
