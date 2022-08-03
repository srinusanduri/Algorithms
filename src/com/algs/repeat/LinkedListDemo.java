package com.algs.repeat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedListDemo {

   public static void main(String[] args) {

      List<Integer> list = new LinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);

      Map<Integer, Integer> map = new HashMap<>();
      map.put(2, 3);

      System.out.println(map);

      map.remove(2);

      System.out.println(map);

      System.out.println(list);
      list.remove(Integer.valueOf(3));
      System.out.println(list);

      ((LinkedList<Integer>) list).removeFirst();

      System.out.println(list);

      ((LinkedList<Integer>) list).removeLast();

      System.out.println(list);

   }

}
