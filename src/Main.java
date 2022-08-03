import java.util.*;

public class Main {

   private static final String ID = "id";
   private static final String FIRST_NAME = "firstName";
   private static final String LAST_NAME = "lastName";
   private static final String EMAIL = "email";
   private static final String GUID = "guid";
   private static final String DATE_OF_BIRTH = "dateOfBirth";
   private static final String PASSWORD_SALT = "passwordSalt";
   private static final String ALGORITHM = "algorithm";
   private static final String ENCRYPTED_PASSWORD = "encryptedPassword";
   private static final String ZIP_CODE = "zipCode";
   private static final String IS_SUBSCRIBER = "isSubscriber";
   private static final String ACCOUNT_ID = "accountId";
   private static final String DISPOSITION = "disposition";
   private static final String EMPLOYER_ID = "employerId";
   private static final String ATE_DELIVERED = "ateDelivered";
   private static final String MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
   private static final String HAS_NO_ELIGIBILITY_FILE = "hasNoEligibilityFile";
   private static final String IS_INTERNATIONAL = "isInternational";
   private static final String CREATED_AT = "createdAt";
   private static final String UPDATED_AT = "updatedAt";

   public static void main(String[] args) {

      String SQL = "SELECT" +
              " id AS " + ID + "," +
              " first_name AS " + FIRST_NAME + "," +
              " last_name AS " + LAST_NAME + "," +
              " email AS " + EMAIL + "," +
              " guid AS " + GUID + "," +
              " date_of_birth AS " + DATE_OF_BIRTH + "," +
              " password_salt AS " + PASSWORD_SALT + "," +
              " algorithm AS " + ALGORITHM + "," +
              " password_encrypted_value AS " + ENCRYPTED_PASSWORD + "," +
              " account_id AS " + ACCOUNT_ID + "," +
              " zip AS " + ZIP_CODE + "," +
              " is_subscriber AS " + IS_SUBSCRIBER + "," +
              " disposition AS " + DISPOSITION + "," +
              " employer_id AS " + EMPLOYER_ID + "," +
              " ate_delivered AS " + ATE_DELIVERED + "," +
              " mobile_phone_number AS " + MOBILE_PHONE_NUMBER + ", " +
              " has_no_eligibility_file AS " + HAS_NO_ELIGIBILITY_FILE + ", " +
              " is_international AS " + IS_INTERNATIONAL + ", " +
              " created_at AS " + CREATED_AT + "," +
              " updated_at AS " + UPDATED_AT +
              " FROM account_pre_registration WHERE employer_id = ? AND disposition in (?,?,?) AND created_at < (NOW() - INTERVAL 1 YEAR)";


      String SQL_ALL_EMPLOYERS = "SELECT" +
              " id AS " + ID + "," +
              " first_name AS " + FIRST_NAME + "," +
              " last_name AS " + LAST_NAME + "," +
              " email AS " + EMAIL + "," +
              " guid AS " + GUID + "," +
              " date_of_birth AS " + DATE_OF_BIRTH + "," +
              " password_salt AS " + PASSWORD_SALT + "," +
              " algorithm AS " + ALGORITHM + "," +
              " password_encrypted_value AS " + ENCRYPTED_PASSWORD + "," +
              " account_id AS " + ACCOUNT_ID + "," +
              " zip AS " + ZIP_CODE + "," +
              " is_subscriber AS " + IS_SUBSCRIBER + "," +
              " disposition AS " + DISPOSITION + "," +
              " employer_id AS " + EMPLOYER_ID + "," +
              " ate_delivered AS " + ATE_DELIVERED + "," +
              " mobile_phone_number AS " + MOBILE_PHONE_NUMBER + ", " +
              " has_no_eligibility_file AS " + HAS_NO_ELIGIBILITY_FILE + ", " +
              " is_international AS " + IS_INTERNATIONAL + ", " +
              " created_at AS " + CREATED_AT + "," +
              " updated_at AS " + UPDATED_AT +
              " FROM account_pre_registration WHERE disposition in (?,?,?)";

      System.out.println(SQL);
   }


   public static void main2(String[] args) {
      Deque<String> deque = new ArrayDeque<>();
      deque.offer("arvind");
      deque.offer("vimal");
      deque.add("mukul");
      deque.offerFirst("jai");

      System.out.println("After offerFirst Traversal...");
      for (String s : deque) {
         System.out.println(s);
      }
      deque.poll();
      //deque.pollFirst();//it is same as poll()
      deque.pollLast();

      System.out.println("After pollLast() Traversal...");
      for (String s : deque) {
         System.out.println(s);
      }


   }
}
