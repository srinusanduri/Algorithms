package com.algs.tree;

public class DeleteNodeInBST {

   public static void main(String[] args) {

      DeleteNodeInBST bst = new DeleteNodeInBST();

      // [5,3,6,2,4,null,7]

//      TreeNode root = new TreeNode(5);
//      root.left = new TreeNode(3);
//      root.right = new TreeNode(6);
//      root.left.left = new TreeNode(2);
//      root.left.right = new TreeNode(4);
//      root.right.right = new TreeNode(7);
//
      TreeNode root = new TreeNode(1);
      root.left = null;
      root.right = new TreeNode(2);

      System.out.println(bst.deleteNode(root, 1).val);

   }

   public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
         return null;
      }

      TreeNode parent = root;
      TreeNode current = root;

      while (current != null && current.val != key) {
         parent = current;

         if (key < current.val) {
            current = current.left;
         } else if (key > current.val) {
            current = current.right;
         }
      }

      if (current == null) {
         return root;
      }

      if (current.left == null && current.right == null) {

         if (current != parent) {
            if (parent.left == current) {
               parent.left = null;
            } else {
               parent.right = null;
            }
         }
         else {
            root = null;
         }

      }
      else if (current.left != null && current.right != null) {
         TreeNode rightMinNode = minNode(current.right);
         int rightMinVal = rightMinNode.val;

         deleteNode(root, rightMinVal);

         current.val = rightMinVal;
      }
      else {

         TreeNode child = current.left != null ? current.left : current.right;

         if (current != parent) {
            if (parent.left == current) {
               parent.left = child;
            } else {
               parent.right = child;
            }
         }
         else {
            root = child;
         }
      }

      return root;
   }

   private TreeNode minNode(TreeNode root) {
      TreeNode minNode = root;
      while (root.left != null) {
         minNode = root.left;
      }

      return minNode;
   }


   public static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      public TreeNode(int x) {
         val = x;
      }

      @Override
      public String toString() {
         return val + "";
      }
   }

}
