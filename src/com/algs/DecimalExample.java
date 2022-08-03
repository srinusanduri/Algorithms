package com.algs;

import java.text.DecimalFormat;

public class DecimalExample {

   private static DecimalFormat DECIMAL_FORMAT_1 = new DecimalFormat("0K");
   private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0K");

   public static void main(String[] args) {
      ThreadLocal threadLocal = new ThreadLocal();
      System.out.println(threadLocal.get());

      threadLocal.set("sreenu");

      System.out.println(threadLocal.get());

      othermethod();

   }

   private static void othermethod(){
      System.out.println(new ThreadLocal<>().get());
   }

   private static String formattedTotalRatings(int total) {
      if (total < 1000) {
         return String.valueOf(total);
      }
      float thousands = (float) total / 1000;

      if ((thousands % 1) < 0.05) {
         return (total / 1000) + "K";
      } else {
         return DECIMAL_FORMAT.format(thousands);
      }
   }

   public static void main2(String[] args) {

      int total = 14047;

      float thousands = (float) total / 1000;

      System.out.println(thousands);

      if ((thousands % 1) < 0.05) {
         System.out.println((total / 1000) + "K");
      } else {
         System.out.println(DECIMAL_FORMAT.format(thousands));
      }
   }

}