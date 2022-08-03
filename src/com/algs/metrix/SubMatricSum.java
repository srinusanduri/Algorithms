package com.algs.metrix;

public class SubMatricSum {

   // DP mem table holds results
   private int[][] sum;

   // Pre computing is of order M*N
   public SubMatricSum(int[][] matrix) {

      int rows = matrix.length;
      int cols = matrix[0].length;

      this.sum = new int[rows + 1][cols + 1];

      for (int i = 1; i <= rows; i++) {
         for (int j = 1; j <= cols; j++) {

            int subsum = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];

            sum[i][j] = subsum + matrix[i - 1][j - 1];
         }

      }
   }

   public int subMax(int sRow, int sCol, int eRow, int eCol) {

      return sum[eRow + 1][eCol + 1] - sum[eRow + 1][sCol] - sum[sRow][eCol + 1] + sum[sRow][sCol];

   }

   public static void main(String[] args) {

      int[][] matrix = new int[][]{
            {0, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
      };

      SubMatricSum metrixSum = new SubMatricSum(matrix);

      int subSum = metrixSum.subMax(0, 0, 2, 2);

      System.out.println(subSum);
   }

}
