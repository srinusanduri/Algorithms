package com.algs;

public class DivideIntegers {

   public static void main(String[] args) {

      int dividend = -467;
      int divisor = 8;

      DivideIntegers divideIntegers = new DivideIntegers();

      int quotient = divideIntegers.divide(Integer.MIN_VALUE, 1);

      System.out.println(quotient);

   }

   public int divide(int dividend, int divisor) {

      if (divisor == 0) {
         return Integer.MAX_VALUE;
      }

      if (dividend == Integer.MIN_VALUE && divisor == -1) {
         return Integer.MAX_VALUE;
      }

      long lDividend = Math.abs((long) dividend);
      long lDivisor = Math.abs((long) divisor);

      int result = 0;

      int k = 32;

      while (lDividend >= lDivisor) {

         while ((lDivisor << k) > lDividend) {
            k--;
         }

         lDividend = lDividend - (lDivisor << k);
         result = result + (1 << k);
      }

      return (dividend > 0) ^ (divisor > 0) ? -result : result;
   }

}
