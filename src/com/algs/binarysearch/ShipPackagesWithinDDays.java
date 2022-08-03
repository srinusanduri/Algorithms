package com.algs.binarysearch;

public class ShipPackagesWithinDDays {

   public static void main(String[] args) {

      int[] weights = new int[] {1,2,3,4,5,6,7,8,9,10};
      int D = 5;
      int target = 15;

      ShipPackagesWithinDDays alg = new ShipPackagesWithinDDays();

      boolean b = alg.canBeShipped(weights, D, target);

      System.out.println(b);
   }


   public int shipWithinDays(int[] weights, int D) {

      int min = Integer.MIN_VALUE, max = 0;

      for (int weight : weights) {
         min = Math.max(min, weight);
         max += weight;
      }

      while (min < max) {
         int mid = min + (max - min) / 2;
         //System.out.println("min: " + min + ", max: " + max + ", mid: " + mid);

         if (canBeShipped(weights, D, mid)) {
            max = mid;
         } else {
            min = mid + 1;
         }
      }

      return min;
   }

   private boolean canBeShipped(int[] weights, int D, int target) {

      int days = 0;

      int sum = 0;

      int i = 0;

      while (i < weights.length) {
         sum += weights[i];

         if (sum > target) {
            days++;
            sum = 0;
            if (i == weights.length) {
               days++;
            }
         } else if (sum == target) {
            days++;
            sum = 0;
            i++;
         } else {
            //sum += weights[i];
            i++;
         }
      }

      if (sum > 0) {
         days++;
      }

      System.out.println("target: " + target + ", days: " + days);

      return days <= D;
   }

}
