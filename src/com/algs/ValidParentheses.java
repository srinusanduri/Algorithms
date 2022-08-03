package com.algs;

public class ValidParentheses {

   public static void main(String[] args) {
      String s = "(()";

      System.out.println(longestValidParentheses(s));

   }

   public static int longestValidParentheses(String s) {
      if (s == null || s.length() <= 1) {
         return 0;
      }

      int max = 0;
      int left = 0, right = 0;

      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '(') {
            left++;
         } else {
            right++;
         }

         if (left == right) {
            max = Math.max(max, left * 2);
         } else if (right > left) {
            right = left = 0;
         }
      }

      right = left = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
         if (s.charAt(i) == '(') {
            left++;
         } else {
            right++;
         }

         if (left == right) {
            max = Math.max(max, left * 2);
         } else if (left > right) {
            right = left = 0;
         }
      }

      return max;
   }

}
