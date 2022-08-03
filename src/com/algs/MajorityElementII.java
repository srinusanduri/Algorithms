package com.algs;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

   public static void main(String[] args) {
      int[] nums = {4, 2, 1, 1};

      List<Integer> integers = majorityElement(nums);

      System.out.println(integers);
   }


   public static List<Integer> majorityElement(int[] nums) {

      List<Integer> majorities = new ArrayList<>();

      if (nums == null || nums.length == 0) {
         return majorities;
      } else if (nums.length == 1) {
         majorities.add(nums[0]);
         return majorities;
      }

      int candidate1 = nums[0], counter1 = 0;
      int candidate2 = nums[1], counter2 = 0;

      for (int num : nums) {
         if (candidate1 == num) {
            counter1++;
         } else if (candidate2 == num) {
            counter2++;
         } else if (counter1 == 0) {
            candidate1 = num;
            counter1 = 1;
         } else if (counter2 == 0) {
            candidate2 = num;
            counter2 = 1;
         } else {
            counter1--;
            counter2--;
         }
      }

      counter1 = 0;
      counter2 = 0;
      for (int num : nums) {
         if (candidate1 == num) {
            counter1++;
         } else if (candidate2 == num) {
            counter2++;
         }
      }

      if (counter1 > nums.length / 3) {
         majorities.add(candidate1);
      }

      if (counter2 > nums.length / 3) {
         majorities.add(candidate2);
      }

      return majorities;
   }

}
