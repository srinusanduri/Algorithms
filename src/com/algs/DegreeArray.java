package com.algs;

import java.util.Arrays;

public class DegreeArray {

   public static void main(String[] args) {
      int[] nums = {6,5,5};

      int shortestSubArray = findShortestSubArray(nums);

      System.out.println(shortestSubArray);

   }

   public static int findShortestSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int[] numsCopy = nums.clone();

      Arrays.sort(numsCopy);

      int candidate = numsCopy[0];
      int maxFrequency = 1;

      int curCandidate = candidate;
      int curFrequency = 1;

      for (int i = 1; i < numsCopy.length; i++) {
         if (curCandidate == numsCopy[i]) {
            curFrequency++;
         } else {
            curCandidate = numsCopy[i];
            curFrequency = 1;
         }

         if (curFrequency > maxFrequency) {
            maxFrequency = curFrequency;
            candidate = curCandidate;
         }
      }

      int start = 0;
      while (nums[start] != candidate) {
         start++;
      }

      int end = nums.length - 1;
      while (nums[end] != candidate) {
         end--;
      }

      return end - start + 1;
   }

}
