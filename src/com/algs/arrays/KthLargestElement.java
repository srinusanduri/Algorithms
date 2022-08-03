package com.algs.arrays;


import java.util.Random;

class KthLargestElement {

   private static final Random RANDOM = new Random();

   public static void main(String[] args) {
      int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
      int k = 4;

      KthLargestElement alg = new KthLargestElement();
      int kthLargest = alg.findKthLargest(nums, k);
      System.out.println(kthLargest);
   }

   public int findKthLargest(int[] nums, int k) {
      // required index = nums.length - k;

      return findKthLargestInternal(nums, 0, nums.length - 1, (nums.length - k));
   }

   private int findKthLargestInternal(int[] nums, int start, int end, int k) {

      int pivotIndex = partition(nums, start, end);

      if (pivotIndex == k) {
         return nums[pivotIndex];
      }

      if (pivotIndex > k) {
         return findKthLargestInternal(nums, start, pivotIndex - 1, k);
      } else {
         return findKthLargestInternal(nums, pivotIndex + 1, end, k);
      }

   }

   private int partition(int[] nums, int start, int end) {

      int pivotI = randomIndex(start, end);

      int pivot = nums[pivotI];

      swap(nums, end, pivotI);

      int pivotloc = start;

      for (int j = start; j <= end - 1; j++) {

         if (nums[j] <= pivot) {
            swap(nums, j, pivotloc);
            pivotloc++;
         }
      }

      swap(nums, end, pivotloc);

      return pivotloc;
   }

   private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }


   private int randomIndex(int start, int end) {
      return RANDOM.nextInt(end - start + 1) + start;
   }
}