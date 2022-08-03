package com.algs.arrays;

import java.util.*;


public class SubArraysDivisibleByK {

   public static void main(String[] args) {

//      int[] nums = {4,5,0,-2,-3,1};
//      int k = 5;

      int[] nums = {0, -5};
      int k = 10;

      int i = subarraysDivByK_2(nums, k);

      System.out.println(i);

   }


   public static int subarraysDivByK_1(int[] A, int K) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      int count = 0, sum = 0;
      for(int a : A) {
         sum = (sum + a) % K;
         if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
         count += map.getOrDefault(sum, 0);
         map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      return count;
   }

   public static int subarraysDivByK(int[] A, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);

      int result = 0, sum = 0;

      for (int i =0; i < A.length; i++) {
         //sum += A[i];

         sum = (sum + A[i]) % k;
         if(sum < 0) sum += k;

         result += map.getOrDefault(sum, 0);

         map.put(sum, (map.getOrDefault(sum, 0) + 1));
      }

      return result;
   }

   public static int subarraysDivByK_2(int[] A, int k) {

      if (A == null) {
         return 0;
      }

      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);

      int result = 0;

      int sum = 0;

      for (int i =0; i < A.length; i++) {
         sum += A[i];

         if (k != 0) {
            sum = (sum + A[i]) % k;
            if(sum < 0) sum += k;
         }

         result += map.getOrDefault(sum, 0);

         map.put(sum, (map.getOrDefault(sum, 0) + 1));
      }

      return result;
   }

}
