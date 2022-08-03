package com.algs;

public class TrailingZeroes {

   public static void main(String[] args) {

      TrailingZeroes trailingZeroes = new TrailingZeroes();

      int zeros = trailingZeroes.trailingZeroes(1808548329);

      System.out.println();
      int zeros2 = trailingZeroes.trailingZeroe2s(1808548329);

      System.out.println(zeros);
      System.out.println(zeros2);

   }



   public int trailingZeroes(int n) {

      if (n < 0) {
         return -1;
      }

      int divisor = 5;
      int result = 0;

      while ((n/divisor) > 0) {
         System.out.println("Divisor " + divisor + ", count: " + (n/divisor));
         result = result + (n/divisor);
         divisor = divisor*5;
      }

      return result;
   }

   public int trailingZeroe2s(int n) {

      if (n < 0) {
         return -1;
      }

      int result = 0;

      while (n > 0) {
         result = result + (n/5);
         n = n/5;
      }

      return result;
   }

}
