package com.algs;

public class ReverseString {

   public static void main(String[] args) {

      System.out.println(reverse("sreenu"));

   }

   public static String reverse(String s){

      if (s == null || s.length() <= 0) {
         return s;
      }

      int left = 0;
      int right = s.length()-1;

      //char[] chars = s.toCharArray();

      byte[] bytes = s.getBytes();

      while (left < right) {

         byte tmp = bytes[right];

         bytes[right] = bytes[left];
         bytes[left] = tmp;

         left++;
         right--;
      }

      return new String(bytes);
   }

}
