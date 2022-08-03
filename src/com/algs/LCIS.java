package com.algs;

public class LCIS {

   public static void main(String[] args) {

      int[] nums = {1,3,5,4,7};

      int lengthOfLCIS = findLengthOfLCIS(nums);

      System.out.println(lengthOfLCIS);
   }


   public static int findLengthOfLCIS(int[] nums) {
      int ans = 0, anchor = 0;
      for (int i = 0; i < nums.length; ++i) {
         if (i > 0 && nums[i - 1] >= nums[i]) {
            anchor = i;
         }
         ans = Math.max(ans, i - anchor + 1);
      }
      return ans;
   }

}