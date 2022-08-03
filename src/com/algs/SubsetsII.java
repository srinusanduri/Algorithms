package com.algs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

   public static void main(String[] args) {
      int[] nums = {1, 2, 2, 2};

      System.out.println(subsetsWithDup(nums));
   }

   public static List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> results = new LinkedList<>();
      List<Integer> set = new LinkedList<>();
      results.add(new LinkedList<>(set));
      helper(nums, 0, set, results);
      return results;
   }

   static int counter = 0;

   private static void helper(int[] nums, int start, List<Integer> set, List<List<Integer>> results) {

      String indentation = "";
      int k = counter;
      while (k > 0){
         indentation = indentation + "    ";
         k--;
      }

      System.out.println(indentation + "helper(" + start + "" + ")");
      counter++;

      if (start == nums.length) {
         return;
      }

      for (int i = start; i < nums.length; i++) {
         //System.out.println(start);
         if (i > start && nums[i - 1] == nums[i]) {
            //System.out.println("Skipped: ("+ start + ", " + i + ")");
            continue;
         }
         set.add(nums[i]);
         System.out.println(new LinkedList<>(set));
         results.add(new LinkedList<>(set));
         helper(nums, i + 1, set, results);
         Integer remove = set.remove(set.size() - 1);
         //System.out.println("Removed: " + remove);
      }

      counter--;
   }

}
