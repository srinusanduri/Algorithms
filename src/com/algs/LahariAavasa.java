package com.algs;

public class LahariAavasa {

   private static final int TOTAL = 5413600;

   private static final int WHITE = 2010000;

   private static final int BLACK_PAID = 500000;

   private static final int ARRANGED = 700000;

   public static void main(String[] args) {

      int paid = WHITE + BLACK_PAID;

      int due = (TOTAL - paid);

      int toBeArranged = (due - ARRANGED);

      int venkuToGive = 1000000;

      System.out.println("Due:            " + due);
      System.out.println("Arranged:       " + ARRANGED);
      System.out.println("To be arranged: " + toBeArranged);
      System.out.println("To be arranged if Venku gives 10L: " + (toBeArranged-venkuToGive));
   }

}
