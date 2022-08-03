package com.algs.arrays;

public class MaximumProductSubarray {

   public static void main(String[] args) {


      int[] nums = {2,3,-2,4};

      System.out.println(maxProduct(nums));

   }


   public static int maxProduct(int[] nums) {

      int maxProduct = nums[0];

      // int[][] minmax = new int[nums.length][2];
      // minmax[0] = new int[]{nums[0], nums[0]};

      int min = nums[0];
      int max = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int val = nums[i];
         //int[] pmimmax = minmax[i-1];

         int lmin = min(val, val * min, val * max);
         max = max(val, val * min, val * max);
         min = lmin;

         //minmax[i] = new int[]{min, max};

         maxProduct = Math.max(maxProduct, max);
      }

      return maxProduct;
   }

   private static int min(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
   }

   private static int max(int a, int b, int c) {
      return Math.max(a, Math.max(b, c));
   }

}
