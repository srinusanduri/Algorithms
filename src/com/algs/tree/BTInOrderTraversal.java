package com.algs.tree;

public class BTInOrderTraversal {


   public static void main(String[] args) {

      Node root = new Node(5);
      root.left = new Node(8);
      root.right = new Node(7);

      root.left.left = new Node(12);
      root.left.right = new Node(14);

      root.right.left = new Node(20);
      root.right.right = new Node(21);

      root.right.right.right = new Node(50);

      inorderTraverse(root);

   }


   public static void inorderTraverse(Node node){

      if (node == null) {
         return;
      }

      inorderTraverse(node.left);

      System.out.println(node.value);

      inorderTraverse(node.right);
   }


}

class Node {

   int value;

   Node left;
   Node right;

   Node(){}

   Node(int value){
      this.value = value;
   }

   Node(int value, Node left, Node right){
      this.value = value;
      this.left = left;
      this.right = right;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public Node getLeft() {
      return left;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public Node getRight() {
      return right;
   }
}
