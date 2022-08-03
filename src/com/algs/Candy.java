package com.algs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Candy {

   public static void main2(String[] args) {

      int[] ratings = {1, 0, 2};

      int candy = candy(ratings);

      System.out.println(candy);

   }


   public static int candy(int[] ratings) {

      if (ratings == null || ratings.length == 0) {
         return 0;
      }

      List<Child> children = new ArrayList<>();
      for (int i = 0; i < ratings.length; i++) {
         children.add(new Child(ratings[i], i));
      }

      Collections.sort(children);

      int totalCandies = 0;
      int counter = 0;
      for (int i = 0; i < children.size(); i++) {

         Child curr = children.get(i);
         Child previous = null;
         if (i > 0) {
            previous = children.get(i - 1);
         }

         if (previous != null && curr.rating == previous.rating
               && Math.abs(curr.position - previous.position) == 1) {
            counter = counter;
         } else {
            counter = counter + 1;
         }

         totalCandies = totalCandies + counter;
      }

      return totalCandies;
   }

   static class Child implements Comparable<Child> {

      int rating;
      int position;

      Child(int rating, int position) {
         this.rating = rating;
         this.position = position;
      }

      @Override
      public int compareTo(Child other) {
         if (this.rating < other.rating) {
            return -1;
         } else if (this.rating > other.rating) {
            return 1;
         } else {
            return 0;
         }
      }
   }

   public static void main(String[] args) {

//      List<Child> children = new LinkedList<>();
//      children.add(new Child(5, 0));
//      children.add(new Child(6, 1));
//      children.add(new Child(2, 2));
//      children.add(new Child(1, 3));
//      Collections.sort(children);
//      System.out.println(children);

      List<String> lists = new ArrayList<>();
      lists.add("sreenu");
      lists.add("sanduri");
      lists.add("aravind");
      lists.add("srilatha");
      lists.add("Srilatha");
      lists.add("balaji");

      Collections.sort(lists);

      System.out.println(lists);
   }

}
