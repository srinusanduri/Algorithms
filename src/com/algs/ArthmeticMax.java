package com.algs;

import java.util.Arrays;

public class ArthmeticMax {

   public static void main(String[] args) {
      int arr[] = {-1, -12, -3};

      // O(4^n) solution
//      maxValue = arr[0];
//      recursiveCompute(arr, 1, arr[0]);
//      System.out.println(maxValue);

      String s = "srenu";

      char x = s.charAt(0);
      System.out.println(x);

      // O(n) solution
      //System.out.println(iterativeCompute(arr));
   }

   private static int maxValue;

   private static void recursiveCompute(int arr[], int i, int value) {

      if (i == arr.length) {
         if (value > maxValue) {
            maxValue = value;
         }
         return;
      }

      recursiveCompute(arr, i + 1, value + arr[i]);
      recursiveCompute(arr, i + 1, value - arr[i]);
      recursiveCompute(arr, i + 1, value * arr[i]);

      if (arr[i] != 0) {
         recursiveCompute(arr, i + 1, value / arr[i]);
      }
   }

   private static int iterativeCompute(int arr[]) {

      int maxVal = arr[0];
      int minVal = arr[0];

      for (int idx = 1; idx < arr.length; idx++) {

         int[] values = {maxVal + arr[idx], maxVal - arr[idx], maxVal * arr[idx],
               arr[idx] != 0 ? maxVal / arr[idx] : 0,
               minVal + arr[idx], minVal - arr[idx], minVal * arr[idx],
               arr[idx] != 0 ? minVal / arr[idx] : 0};

         maxVal = Arrays.stream(values).max().getAsInt();
         minVal = Arrays.stream(values).min().getAsInt();
      }

      return maxVal;
   }

}
