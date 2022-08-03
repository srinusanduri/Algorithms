package com.algs.repeat;

/*
   https://stackoverflow.com/questions/13167536/how-to-construct-bst-given-post-order-traversal/13168162#13168162
 */
public class BSTSearch {

   /*
      Find last value in the array which is less than given value
    */
   public static void main(String[] args) {

      int val = 4;
      int[] nums = {5, 6, 7, 8, 15, 18, 12, 14};

      int low = 0;
      int high = nums.length - 1;


      if (nums[low] > val) {
         high = -1;
      }
      else {
         while (low < high && nums[high] > val) {

            int mid = low + (high - low + 1) / 2;

            if (nums[mid] > val) {
               high = mid - 1;
            } else {
               low = mid;
            }
         }
      }

      int lastSmaller = findLastSmaller(nums, 0, nums.length - 1, val);

      System.out.println(nums[high]);

      System.out.println(nums[lastSmaller]);

   }


   // find the last index of a value smaller than cut in a segment of the array
   // using binary search
   // supposes that the segment contains the concatenation of the post-order
   // traversals of the left and right subtrees of a node with value cut,
   // in particular, that the first (possibly empty) part of the segment contains
   // only values < cut, and the second (possibly empty) part only values > cut
   private static int findLastSmaller(int[] nodes, int first, int last, int cut) {

      // If the segment is empty, or the first value is larger than cut,
      // by the assumptions, there is no value smaller than cut in the segment,
      // return the position one before the start of the segment
      if (last < first || nodes[first] > cut) {
         return first - 1;
      }

      int low = first, high = last, mid;

      // binary search for the last index of a value < cut
      // invariants: nodes[low] < cut
      //             (since cut is the root value and a BST has no dupes)
      // and nodes[high] > cut, or (nodes[high] < cut < nodes[high+1]), or
      // nodes[high] < cut and high == last, the latter two cases mean that
      // high is the last index in the segment holding a value < cut
      while (low < high && nodes[high] > cut) {

         // check the middle of the segment
         // In the case high == low+1 and nodes[low] < cut < nodes[high]
         // we'd make no progress if we chose mid = (low+high)/2, since that
         // would then be mid = low, so we round the index up instead of down
         mid = low + (high - low + 1) / 2;

         // The choice of mid guarantees low < mid <= high, so whichever
         // case applies, we will either set low to a strictly greater index
         // or high to a strictly smaller one, hence we won't become stuck.
         if (nodes[mid] > cut) {
            // The last index of a value < cut is in the first half
            // of the range under consideration, so reduce the upper
            // limit of that. Since we excluded mid as a possible
            // last index, the upper limit becomes mid-1
            high = mid - 1;
         } else {
            // nodes[mid] < cut, so the last index with a value < cut is
            // in the range [mid .. high]
            low = mid;
         }
      }
      // now either low == high or nodes[high] < cut and high is the result
      // in either case by the loop invariants
      return high;
   }

}
