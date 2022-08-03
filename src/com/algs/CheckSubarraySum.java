package com.algs;

import java.util.*;

public class CheckSubarraySum {

   public static void main(String[] args) {

      int[] nums = {0,1,0,0};

      boolean b = checkSubarraySum(nums, 0);

      System.out.println(b);

   }

   public static boolean checkSubarraySum(int[] nums, int k) {

      if (nums == null || nums.length < 2) {
         return false;
      }

      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);

      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];

         if (k != 0) {
            sum = sum%k;
         }

         if (map.containsKey(sum)) {
            if((i - map.get(sum)) > 1){
               return true;
            }
         }
         else {
            map.put(sum, i);
         }
      }

      return false;
   }

}
