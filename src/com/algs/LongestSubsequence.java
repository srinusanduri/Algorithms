package com.algs;

public class LongestSubsequence {

   public static void main(String[] args) {

      String text1 = "cbeaghdg";
      String text2 = "eabd";

      LongestSubsequence driver = new LongestSubsequence();

      System.out.println(new StringBuilder(text1).reverse().toString());

      System.out.println(driver.longestCommonSubsequenceString(text1, text2));

   }

   public String longestCommonSubsequenceString(String text1, String text2) {
      if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
         return null;
      }

      int[][] dp = new int[text1.length()+1][text2.length()+1];

      for (int i = 1; i <= text1.length(); i++) {
         char char1 = text1.charAt(i-1);
         for (int j = 1; j <= text2.length(); j++) {
            char char2 = text2.charAt(j-1);

            if (char1 == char2) {
               dp[i][j] = 1 + dp[i-1][j-1];
            }
            else {
               dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
         }
      }

      String subsequence = "";

      int i = text1.length();
      int j = text2.length();

      while (i > 0 && j > 0) {
         if (dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1]) {
            subsequence = text1.charAt(i-1) + subsequence;
            i--;
            j--;
         }
         else if (dp[i-1][j] > dp[i][j-1]) {
            i--;
         }
         else {
            j--;
         }
      }

      return subsequence;
   }

   public int longestCommonSubsequence(String text1, String text2) {
      if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
         return 0;
      }

      int[][] dp = new int[text1.length()+1][text2.length()+1];

      for (int i = 1; i <= text1.length(); i++) {
         char char1 = text1.charAt(i-1);
         for (int j = 1; j <= text2.length(); j++) {
            char char2 = text2.charAt(j-1);

            if (char1 == char2) {
               dp[i][j] = 1 + dp[i-1][j-1];
            }
            else {
               dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
         }
      }

      return dp[text1.length()][text2.length()];
   }

}
