package com.algs.trie;

import com.algs.Test;
import java.util.HashMap;
import java.util.Map;

class Trie {

   public static void main(String[] args) {
      Trie trie = new Trie();

      trie.insert("apple");

      boolean found = trie.search("apple");
      System.out.println(found);

      System.out.println('a' - '0');
      System.out.println('b' - '0');

   }

   class Node {
      char c;
      Map<Character, Node> children = new HashMap<>();
      boolean word = false;

      Node(char c) {
         this.c = c;
      }

      boolean containsChild(char c) {
         return children.containsKey(c);
      }

      Node getChild(char c) {
         return children.get(c);
      }

      Node child(char c) {
         Node child = null;
         if (children.containsKey(c)) {
            child = children.get(c);
         } else {
            child = new Node(c);
            children.put(c, child);
         }

         return child;
      }

//         @Override
//         public int hashCode(){
//             return c - '0';
//         }

//         @Override
//         public boolean equals(Object obj) {
//             Node that = (Node) obj;
//             return this.c == that.c;
//         }
   }

   private Node root = new Node('/');

   /**
    * Initialize your data structure here.
    */
   public Trie() {
   }

   /**
    * Inserts a word into the trie.
    */
   public void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
         node = node.child(c);
      }
      node.word = true;
   }

   /**
    * Returns if the word is in the trie.
    */
   public boolean search(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
         if (!node.containsChild(c)) {
            return false;
         }
         node = node.getChild(c);
      }

      return node.word;
   }

   /**
    * Returns if there is any word in the trie that starts with the given prefix.
    */
   public boolean startsWith(String prefix) {
      Node node = root;
      for (char c : prefix.toCharArray()) {
         if (!node.containsChild(c)) {
            return false;
         }
         node = node.getChild(c);
      }

      return true;
   }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */