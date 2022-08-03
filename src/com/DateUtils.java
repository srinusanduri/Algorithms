package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

   private static final DateTimeFormatter YYYYMMDD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

   public static LocalDate toLocalDate(String dateString) {
      if (dateString == null) {
         return null;
      }

      try {
         dateString = dateString.replace("-", "").replace("/", "");
         return LocalDate.parse(dateString, YYYYMMDD_DATE_FORMATTER);
      } catch (Exception e) {
         return null;
      }
   }

   public static void main(String[] args) {

      LocalDate localDate = toLocalDate("1965-03/01");

      System.out.println(localDate);

   }

}
