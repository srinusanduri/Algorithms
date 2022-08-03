package com.algs;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


   public static void main(String[] args) {

      char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
      };

      System.out.println(isValidSudoku(board));
   }


   public static boolean isValidSudoku(char[][] board) {
      Set<Character>[] rows = new Set[9];
      Set<Character>[] cols = new Set[9];
      Set<Character>[] grids = new Set[9];

      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (c == '.') {
               continue;
            }

            int k = (i / 3) + (j / 3) * 3;

            if (cols[i] == null) cols[i] = new HashSet<>();
            if (rows[j] == null) rows[j] = new HashSet<>();
            if (grids[k] == null) grids[k] = new HashSet<>();

            if (cols[i].contains(c) || rows[j].contains(c) || grids[k].contains(c)) {
               return false;
            }

            cols[i].add(c);
            rows[j].add(c);
            grids[k].add(c);
         }
      }
      return true;
   }


}
