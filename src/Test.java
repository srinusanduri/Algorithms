
import java.util.Collections;
import java.util.PriorityQueue;

public class Test {


   public static void main(String[] args) {

      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

      priorityQueue.add(2);
      priorityQueue.add(25);

      priorityQueue.add(456);

      priorityQueue.add(23);

      priorityQueue.add(56);

      priorityQueue.add(34);

      priorityQueue.add(487);

      System.out.println(priorityQueue.size());


      System.out.println(priorityQueue.poll() + ", " + priorityQueue.poll());

   }



}
