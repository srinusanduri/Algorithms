package com.algs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DistantBarcode {

   public static void main(String[] args) {

      int[] barcodes = new int[] {7,7,7,8,5,7,5,5,5,8};

      DistantBarcode distantBarcode = new DistantBarcode();

      int[] ints = distantBarcode.rearrangeBarcodes(barcodes);

      System.out.println(ints);

      for (int i = ints.length - 1; i >= 0; i--) {
         System.out.print(ints[i]);
         System.out.print(", ");
      }

   }

   public int[] rearrangeBarcodes(int[] barcodes) {
      Map<Integer, Integer> map = new HashMap<>();
      //Arrays.sort(barcodes);
      for (int i = barcodes.length - 1; i >= 0; i--) {
         map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
      }
      // Here using the priority queue to sort the map with highest value first
      PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue());

      pq.addAll(map.entrySet());

      int idx = 0;
      Arrays.fill(barcodes, -1);


      while (!pq.isEmpty()) {
         Map.Entry m = pq.poll();
         int key = (int) m.getKey();
         int val = (int) m.getValue();
         int j = val;
         while (j > 0) {
            if (barcodes[idx] == -1) {
               barcodes[idx] = key;
               idx = idx + 2;
               j--;
            } else {
               idx++;
            }
            if (idx >= barcodes.length) {
               idx = 0;
            }
         }
      }
      return barcodes;
   }

}
