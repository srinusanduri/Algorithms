package com.algs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

   public static void main(String[] args) {
      int[] nums = {1, 2, 3};

      System.out.println(permute(nums));
   }
   public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> permutations = new ArrayList<>();
      if (nums == null || nums.length == 0) {
         return permutations;
      }

      List<Integer> current = new ArrayList<>();
      Set<Integer> path = new HashSet<>();

      helper(nums, 0, path, current, permutations);

      return permutations;
   }

   private static void helper(int[] nums, int idx, Set<Integer> path, List<Integer> current,
         List<List<Integer>> permutations) {



      if (path.size() == nums.length) {
         permutations.add(new ArrayList<>(current));
//         path.remove(idx);
//         current.remove(current.size() - 1);
         return;
      }

      path.add(idx);
      current.add(nums[idx]);

      for (int i = idx + 1; i < (idx + nums.length); i++) {
         int k = i % nums.length;
         if (!path.contains(k)) {
            helper(nums, k, path, current, permutations);
         }
      }

      path.remove(idx);
      current.remove(current.size() - 1);
   }

}
