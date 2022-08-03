package com.algs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {


   public static void main(String[] args) {

      int[] barcodes = new int[] {7,7,7,8,5,7,5,5,5,8};

      Solution solution = new Solution();

      int[] ints = solution.rearrangeBarcodes(barcodes);

      //System.out.println(ints);

      for (int i = 0; i < ints.length; i++) {
         System.out.print(ints[i]);
         System.out.print(", ");
      }

   }

   public int[] rearrangeBarcodes(int[] barcodes) {

      // Step 1: build frequency map
      Map<Integer, Integer> barcodesMap = new HashMap<>();
      for (int barcode : barcodes) {
         barcodesMap.put(barcode, barcodesMap.getOrDefault(barcode, 0) + 1);
      }

      // Step 2: Build max frequency priority queue
//         PriorityQueue<Map.Entry<Integer, Integer>> maxQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

//         maxQueue.addAll(barcodesMap.entrySet());

      // Step 3: rearrange barcodes

      int idx = 0;

      for (Map.Entry<Integer, Integer> entry : barcodesMap.entrySet()) {
         Integer barcode = entry.getKey();
         Integer frequency = entry.getValue();

         while (frequency > 0) {
            if (idx >= barcodes.length) {
               idx = 1;
            }

            barcodes[idx] = barcode;
            idx = idx + 2;
            frequency--;
         }
      }

//         while (!maxQueue.isEmpty()) {

//             Map.Entry<Integer, Integer> fEntry = maxQueue.poll();
//             int frequency = fEntry.getValue();
//             int barcode = fEntry.getKey();

//             while (frequency > 0) {
//                 if (idx >= barcodes.length) {
//                     idx = 1;
//                 }

//                 barcodes[idx] = barcode;
//                 idx = idx + 2;
//                 frequency--;
//             }

//         }

      return barcodes;
   }
}
