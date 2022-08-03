package com.algs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ThreeNumberMaxProduct {

   public static void main(String[] args) {

      int[] arr = {-100, -10, -4, -3, -2, 3};

      //System.out.println(maxProduct(arr));

      int a = -4;
      int b = -6;

      System.out.println(a+b);
      System.out.println(b-a);
   }

   public static int maxProduct(int[] arr) {

      if (arr == null || arr.length < 3) {
         return 0;
      }

      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      minHeap.add(arr[0]);
      minHeap.add(arr[1]);
      minHeap.add(arr[2]);

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
         }
      });

      maxHeap.add(arr[0]);
      maxHeap.add(arr[1]);

      for (int i = 2; i < arr.length; i++) {
         if (arr[i] < maxHeap.peek()) {
            maxHeap.remove();
            maxHeap.add(arr[i]);
         }

         if (i > 2 && arr[i] > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(arr[i]);
         }
      }

      return Math.max(minHeap.poll() * minHeap.poll() * minHeap.peek(),
            maxHeap.poll() * maxHeap.poll() * minHeap.poll());
   }

}
