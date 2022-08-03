package com.algs;

public class MinJumpGame {

   public static void main(String[] args) {

      int[] arr = {2,0,0};
//                 2 1 2 1 0

//      int[] arr = {1, 1, 1, 1, 1};

      int jump = jump(arr);

      System.out.println(jump);
   }

   /*


   1 1 1 1 1

   4 3 2 1 0

    */

   public static int jump(int[] nums) {

      if (nums == null || nums.length <= 1) {
         return 0;
      }

      int[] jumps = new int[nums.length];
      jumps[nums.length-1] = 0;

      for (int i = nums.length-2; i >= 0; i--) {
         jumps[i] = Integer.MAX_VALUE;

         for (int j = nums.length-1; j > i; j--) {
            if (i + nums[i] >= j && jumps[j] != Integer.MAX_VALUE) {
               jumps[i] = Math.min(jumps[i], jumps[j] + 1);
//               break;
            }
         }
      }

      return jumps[0];
   }

}
