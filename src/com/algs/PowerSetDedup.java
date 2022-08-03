package com.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetDedup {

   public static void main(String[] args) {

      int[] nums = {1, 2, 3};

      System.out.println(subsetsWithDup(nums));
   }


   public static List<List<Integer>> subsetsWithDup(int[] nums) {

      List<List<Integer>> subsets = new ArrayList<>();

      Arrays.sort(nums);

      List<Integer> set = new ArrayList<>();

      dedupSubsets(nums, 0, set, subsets);

      return subsets;
   }

   private static void dedupSubsets(int[] nums, int idx, List<Integer> set, List<List<Integer>> subsets) {

      for (int i = idx; i < nums.length; i++) {
         set.add(nums[i]);
         subsets.add(new ArrayList<Integer>(set));

         int nextIdx = i + 1;
         while (nextIdx < nums.length && nums[i] == nums[nextIdx]) {
            nextIdx++;
         }

         dedupSubsets(nums, nextIdx, set, subsets);
         set.remove(set.size() - 1);
      }
   }

}
