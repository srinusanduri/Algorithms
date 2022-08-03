package com.algs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumCostToCutStick {

   int minCost = Integer.MAX_VALUE;

   public static void main(String[] args) {
     int n = 7;
     int[] cuts = new int[] {1,3,4,5};

      MinimumCostToCutStick mccs = new MinimumCostToCutStick();
      int cost = mccs.minCost(n, cuts);
      System.out.println(cost);
   }

   public int minCost(int n, int[] cuts) {

      Set<Integer> performed = new HashSet<>();

      LinkedList<Integer> order = new LinkedList<>();

      int minCost = Integer.MAX_VALUE;

      for (int cut : cuts) {
         performed.add(cut);
         order.add(cut);

         int cost1 = subStickCutCost(0, cut, cuts, performed, order);
         int cost2 = subStickCutCost(cut, n, cuts, performed, order);

         minCost = Math.min(minCost, cost1 + cost2 + n);

         performed.remove(cut);
         order.removeLast();
      }

      return minCost;
   }

   private int subStickCutCost(int start, int end, int[] cuts, Set<Integer> performed, LinkedList<Integer> order) {

      if ((end - start) == 1) return 0;

      int minCost = Integer.MAX_VALUE;

      for (int cut : cuts) {
         if (!performed.contains(cut) && start < cut && cut < end) {
            performed.add(cut);
            order.add(cut);

            int cost1 = subStickCutCost(start, cut, cuts, performed, order);
            int cost2 = subStickCutCost(cut, end, cuts, performed, order);

            minCost = Math.min(minCost, cost1 + cost2 + end - start);

            performed.remove(cut);
            order.removeLast();
         }
      }

      return minCost == Integer.MAX_VALUE ? 0 : minCost;
   }

}
