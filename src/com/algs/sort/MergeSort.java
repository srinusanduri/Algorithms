package com.algs.sort;

class MergeSort {


   public static void main(String[] args) {

      int[] nums = new int[]{5, 2, 3, 1};

      MergeSort sort = new MergeSort();

      int[] sorted = sort.sortArray(nums);

      for (int val : sorted) {
         System.out.print(val + " ");
      }
   }

   public int[] sortArray(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return nums;
      }

      mergeSort(nums, 0, nums.length - 1);

      return nums;
   }

   private void mergeSort(int[] nums, int start, int end) {
      if (start >= end) {
         return;
      }

      int mid = start + (end - start) / 2;

      mergeSort(nums, start, mid);
      mergeSort(nums, mid + 1, end);

      merge(nums, start, mid, end);
   }

   private void merge(int[] nums, int start, int mid, int end) {
      if (nums[mid] <= nums[mid + 1]) {
         return;
      }

      int[] part1 = new int[mid - start + 1];
      for (int i = 0; i < part1.length; i++) {
         part1[i] = nums[start + i];
      }

      int[] part2 = new int[end - mid];
      for (int i = 0; i < part2.length; i++) {
         part2[i] = nums[mid + 1 + i];
      }

      int i = 0;
      int j = 0;

      int index = start;

      while (i < part1.length && j < part2.length) {
         if (part1[i] <= part2[j]) {
            nums[index++] = part1[i++];
         } else {
            nums[index++] = part2[j++];
         }
      }

      while (i < part1.length) {
         nums[index++] = part1[i++];
      }

      while (j < part2.length) {
         nums[index++] = part2[j++];
      }
   }
}
