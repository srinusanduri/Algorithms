package com.algs.dp;

public class RegularExpressionMatching {

   public boolean isMatch(String s, String p) {
        /*
            dp[i][j] = whether the first i-character sequence in s matches the first j-character sequence in p
            we set dp[0][0] = true, because the first 0 character in s always matches the first 0 character in p

            For better readability, I will make this notation:
            s[i] means the i-th character in string s.
            For example, s = "abc", s[1] = 'a', s[2] = 'b', s[3] = 'c'

            The above notation will give us a consistent view of the relationship between dp[i][j], s[i] and p[j].
            For example, if we have s = "ab", p = "ac", we will get:
            dp[0][0] = true (default base case);
            dp[1][0] = false (because s[1...1] = "a" and p[0] does not exist based on our notation);
            dp[1][1] = true (because s[1...1] = "a" and p[1...1] = "a", they match);
            dp[2][0] = false (because s[1...2] = "ab" and p[0] does not exist);
            dp[2][1] = false (because s[1...2] = "ab" and p[1...1] = "a", they don't match);
            dp[2][2] = false (because s[1...2] = "ab" and p[1...2] = "ac", they don't match);
            As a result, dp[s.length()][p.length()] = dp[2][2] = false.
            We will return false, meaning that s does not match p.

            With the above notation, we have:
            If we are currently at s[i] and p[j]:
            1. if (p[j] == s[i])
                    - The i-th character in s matches the j-th character in p, so dp[i][j] now depends on dp[i-1][j-1]
                    - Therefore we have dp[i][j] = dp[i-1][j-1]
            2. if (p[j] == '.')
                    - The j-th character in p is '.', meaning that it can represent any single character, it is the same as 1
                    - Therefore we have dp[i][j] = dp[i-1][j-1]
            3. if (p[j] == '*')
                    - The j-th character in p is '*', meaning that the character of p[j-1] can be repeated multiple times or can be not exising
                    - Now we will need to check p[j-1]:
                            3.1 -  if (p[j-1] != s[i] AND p[j-1] != '.')
                                    - In this case, the only possible scenario that s[1...i] matches p[1...j] is that s[1...i] matches p[1...j-2]
                                    - For example, when i = 2 and j = 4, p[1...4] = "abc*", s[1...2] = "ab":
                                            - p[4] = '*', p[4-1] = p[3] = 'c' while s[2] = 'b', so p[3] != s[2] and p[3] != '.'
                                            - But since s[1...2] matches p[1...2], s[1...2] still matches p[1...4] in this case
                                    - Therefore we have dp[i][j] = dp[i][j-2]
                            3.2 - if (p[j-1] == s[i] OR p[j-1] == '.')
                                    3.2.1 - if (s[1...i] does not match p[1...j-2])
                                    - In this case, we know that the character s[i] needs to match the character p[j-1]. Thus as long as s[1...i-1] matches p[1...j], we will have s[1....i] matches p[1...j]
                                    - For example, when i = 3 and j = 4, p[1...4] = "abc*", s[1...3] = "abc":
                                            - s[1...2] matches p[1...4] because of 3.1: since we have "c*", we can treat p = "abc*" as equivalent to p = "ab" when matching "ab", because c* means c can be repeating or not existing
                                            - since s[3] = 'c' which is the same as p[3], it matches at s[3]
                                    - Another example, when i = 4 and j = 4, p[1...4] = "abc*", s[1...4] = "abcc"
                                            - From previous example, we know that dp[3][4] is true. So since we have "c*", c can repeat multiple times. Therefore as long as s[4] = 'c' = p[4-1], we know that dp[4][4] = dp[3][4] = true
                                    - Therefore we have dp[i][j] = dp[i-1][j]
                                    - I noticed that some other solutions also include dp[i][j-1] as a condition where s[i] only appears once, but I think it is redundant here because dp[i-1][j] can be applied to both one appearance and multiple appearances. But if we have another quantifier like "?" which only allows one appearance, we should include dp[i][j-1].
                                    3.2.2 - if (s[1...i] does match p[1...j-2])
                                    - In this case, we actually don't really need to care about p[j-1...j] because the previous sequence matches, and we can now treat p[j-1...j] as matching nothing.
                                    - Therefore we have dp[i][j] = dp[i][j-2]


        To construct the boolean[][] dp array, we also need an initialization on "nothing in s" (s[0]) matching p[1...j]:
        1. dp[0][0] = true
        2. dp[0][i] = true if p[i+1] == '*' AND dp[0][i-2] == true, otherwise false
            For example:
            p = "a*b*"
            dp[0][0] = true;
            dp[0][1] = false (because s[0] does not exist while p[1...1] = "a");
            dp[0][2] = true (because s[0] does not exist, but p[1...2] = "a*" meaning that a can be repeating or not existing);
            dp[0][3] = false (because s[0] does not exist while p[1...3] = "a*b");
            dp[0][4] = true (because s[0] does not exist while p[1...4] = "a*b*", b can be not existing, and dp[0][2] is true meaning that we already have a match for anything before p[3...4]);
        */

      if (s == null || p == null) {
         return false;
      }
      boolean[][] dp = new boolean[s.length() + 1][p.length()
            + 1]; // by default every element is false
      dp[0][0] = true;
      char[] string = new char[s.length() + 1];
      char[] pattern = new char[p.length() + 1];
      // we don't care about what character is on index 0. It is a way to make our view of index in dp[][] and string[] and pattern[] consistent. Our process starts at index==1 for string and pattern.
      string[0] = (char) 0;
      pattern[0] = (char) 0;
      for (int i = 0; i < s.length(); ++i) {
         string[i + 1] = s.charAt(i);
      }
      for (int i = 0; i < p.length(); ++i) {
         pattern[i + 1] = p.charAt(i);
      }

      dp[0][0] = true;
      // initialization of dp, for base cases
      for (int i = 1; i < pattern.length; ++i) {
         // here we assume that pattern[1] (i.e. p.charAt(0)) will never be '*' based on the description of the problem which states that '*' matches zero or more of the preceding element, so it must have a preceding element otherwise it is not a valid input.
         if (pattern[i] == '*' && dp[0][i - 2]) {
            dp[0][i] = true;
         }
      }

      for (int i = 1; i < string.length; ++i) {
         for (int j = 1; j < pattern.length; ++j) {
            if (pattern[j] == string[i] || pattern[j] == '.') {
               // scenario 1 and 2: current character matches, we just need to know if previous sequence matches or not
               dp[i][j] = dp[i - 1][j - 1];
            } else if (pattern[j] == '*') {
               if (pattern[j - 1] != string[i] && pattern[j - 1] != '.') {
                  // scenario 3.1: we should treat pattern[j-1...j] as matching nothing in string, it is valid because pattern[j] == '*', therefore we want to know if string[1...i] matches pattern[1...j-2]
                  dp[i][j] = dp[i][j - 2];
               } else {
                  // scenario 3.2.1 and 3.2.2: since pattern won't change, we just need to make sure one of 3.2.1 and 3.2.2 is true for dp is true: either pattern[j-1...j] matches string[i], or pattern[j-1...j] matches nothing in string
                  // if pattern[j-1] matches string[i], we just need to know if string[i-1] matches pattern[j]: abc* matches abc and abcc, if we want to know if abc matches abc*, we just need to know if ab matches abc*; if we want to know if abcc matches abc*, we just need to know if abc matches abc*
                  // if pattern[j-1] matches nothing in string, it is scenario 3.1
                  dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
               }
            }
         }
      }
      return dp[s.length()][p.length()];
   }

}
