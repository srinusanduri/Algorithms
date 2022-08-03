package com.algs.repeat;

class Solution {

   public static void main1(String[] args) {

      int len = 4;

      int i = 3;

      System.out.println(3 % 5);
      System.out.println(4 % 5);
      System.out.println(5 % 5);
      System.out.println(1 % 5);
      System.out.println(2 % 5);
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      //int[] gas  = {1,2,3,4,5};
      //int[] cost = {3,4,5,1,2};

      int[] gas =  {3,1,1};
      int[] cost = {1,2,2};

      int start = sol.canCompleteCircuit(gas, cost);

      System.out.println("Start: " + start);
   }

   public int canCompleteCircuit(int[] gas, int[] cost) {

      int net = -1;
      int start = 0;
      int i = 0;

      int loops = 0;

      while (true) {

         if (i == 0) {
            loops++;
         }

         if (loops > 2) {
            return -1;
         }

         if (net <= 0) {
            start = i;
            net = gas[i] - cost[i];
         } else {

            net = (net + gas[i] - cost[i]);

            if ((net >= 0) && (((i + 1) == start)) || (i == gas.length-1 && start == 0)) {
               return start;
            }
         }

         System.out.println("At: " + i + ", net: " + net + ", start: "+ start);

         i = (i + 1) % (gas.length);
      }
   }
}
