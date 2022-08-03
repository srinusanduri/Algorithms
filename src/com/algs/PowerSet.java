package com.algs;

import java.util.LinkedList;
import java.util.List;

public class PowerSet {

   public static void main(String[] args) {

      int[] nums = {1, 2, 3};

      System.out.println(subsets(nums));
   }

   public static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> subsets = new LinkedList<>();

      for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
         List<Integer> set = new LinkedList<>();
         for (int j = 0; j < nums.length; j++) {
            if ((i & (1 << j)) != 0) {
               set.add(nums[j]);
            }
         }
         subsets.add(set);
      }

      return subsets;
   }

}
