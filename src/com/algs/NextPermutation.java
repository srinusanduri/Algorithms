package com.algs;

public class NextPermutation {

   public static void main(String[] args) {
      int[] nums = {5, 1, 1};

      nextPermutation(nums);

      System.out.print(nums[0] + ", " + nums[1] + ", " + nums[2]);
   }

   public static void nextPermutation2(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i + 1] <= nums[i]) {
         i--;
      }
      if (i >= 0) {
         int j = nums.length - 1;
         while (j >= 0 && nums[j] <= nums[i]) {
            j--;
         }
         swap(nums, i, j);
      }
      reverse(nums, i + 1);
   }

   private static void reverse(int[] nums, int start) {
      int i = start, j = nums.length - 1;
      while (i < j) {
         swap(nums, i, j);
         i++;
         j--;
      }
   }


   public static void nextPermutation(int[] nums) {
      int idx = nums.length - 2;
      while (idx >= 0 && nums[idx] >= nums[idx+1]) {
         idx--;
      }

      if (idx >= 0) {
         int k = idx + 1;
         while (k < nums.length) {
            if (nums[idx] > nums[k]) {
               break;
            }
            k++;
         }

         k--;

         swap(nums, idx, k);
      }

      // reverse sub array after idx.
      int i = idx+1;
      int j = nums.length - 1;
      while (i < j) {
         swap(nums, i, j);
         i++;
         j--;
      }
   }

   private static void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

}
