package com.algs.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

   public boolean isBalanced(TreeNode root) {
      if (root == null) {
         return true;
      }

      if (root.left == null && root.right == null) {
         return true;
      }

      int left = height(root.left);
      int right = height(root.right);

      if(Math.abs(left-right)>1)
         return false;

      return isBalanced(root.left) && isBalanced(root.right);
   }

   private int height(TreeNode root) {
      if (root == null) {
         return 0;
      }

      if (root.left == null && root.right == null) {
         return 1;
      }

      int left = height(root.left);
      int right = height(root.right);

      return left > right ? left + 1 : right + 1;
   }

   public TreeNode stringToTreeNode(String input) {
      input = input.trim();
      input = input.substring(1, input.length() - 1);
      if (input.length() == 0) {
         return null;
      }

      String[] parts = input.split(",");
      String item = parts[0];
      TreeNode root = new TreeNode(Integer.parseInt(item));
      Queue<TreeNode> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);

      int index = 1;
      while (!nodeQueue.isEmpty()) {
         TreeNode node = nodeQueue.remove();

         if (index == parts.length) {
            break;
         }

         item = parts[index++];
         item = item.trim();
         if (!item.equals("null")) {
            int leftNumber = Integer.parseInt(item);
            node.left = new TreeNode(leftNumber);
            nodeQueue.add(node.left);
         }

         if (index == parts.length) {
            break;
         }

         item = parts[index++];
         item = item.trim();
         if (!item.equals("null")) {
            int rightNumber = Integer.parseInt(item);
            node.right = new TreeNode(rightNumber);
            nodeQueue.add(node.right);
         }
      }
      return root;
   }

   public static void main(String[] args) {

      String line = "[1,2,2,3,3,null,null,4,4]";

      BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

      TreeNode root = balancedBinaryTree.stringToTreeNode(line);

      boolean isBalanced = balancedBinaryTree.isBalanced(root);

      System.out.print(isBalanced);
   }

   public static void main2(String[] args) throws IOException {

      BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while ((line = in.readLine()) != null) {
         TreeNode root = balancedBinaryTree.stringToTreeNode(line);

         boolean isBalanced = balancedBinaryTree.isBalanced(root);

         System.out.print(isBalanced);
      }
   }


   public class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }
}
