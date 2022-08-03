package com.algs;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {

   private static final ProgramActivityComparator ACTIVITY_COMPARATOR = new ProgramActivityComparator();

   private static Executor executor = Executors.newFixedThreadPool(10);

   public static void main(String[] args) {

      SortedSet<ProgramRule> activities = new TreeSet<>(ACTIVITY_COMPARATOR);

      ProgramRule activity1 = new ProgramRule();
      activity1.setDisplayOrder(0);

      ProgramRule activity2 = new ProgramRule();
      activity2.setDisplayOrder(1);

      activities.add(activity1);
      activities.add(activity2);

      for (ProgramRule rule : activities) {
         System.out.println(rule.getDisplayOrder());
      }

   }


   private static class ProgramRule {

      private int displayOrder;

      public void setDisplayOrder(int displayOrder) {
         this.displayOrder = displayOrder;
      }

      public int getDisplayOrder() {
         return displayOrder;
      }
   }


   private static final class ProgramActivityComparator implements Comparator<ProgramRule> {

      @Override
      public int compare(ProgramRule activity1, ProgramRule activity2) {
         int displayOrder1 = activity1.getDisplayOrder();
         int displayOrder2 = activity2.getDisplayOrder();

         if (displayOrder1 == displayOrder2) {
            return 0;
         } else {
            return displayOrder1 < displayOrder2 ? -1 : 1;
         }
      }
   }

}
