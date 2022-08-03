package com.algs.metrix;

public class SearchInMultiplicationMatrix {


   public static void main(String[] args) {
      SearchInMultiplicationMatrix mm = new SearchInMultiplicationMatrix();

      int n = 26;
      int x = 4;

      int aaa = 10;
      int aaaa = 5;

      double a = Math.pow(10, 5);

      System.out.println(a);
      System.out.println(a*a);

//      int count = mm.countOccurences(n, x);
//      System.out.println(count);
   }

   private int countOccurences(int n, int x) {
      int count = 0;

      int i = 0;
      int j = n-1;

      while (i < n && j >= 0) {

         int val = (i+1) * (j+1);

         // case 1: val == x ==> i = i+1, j = j-1
         // case 2: val < x ==> i = i+1, j = j
         // case 3: val > x ==>  i = i, j = j-1

         if (val == x) {
            count++;
            i++;
            j--;
         }
         else if (val < x) {
            i++;
         }
         else {
            j--;
         }
      }

      return count;
   }

}
