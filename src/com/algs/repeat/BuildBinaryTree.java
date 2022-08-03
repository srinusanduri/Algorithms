package com.algs.repeat;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class BuildBinaryTree {

   public static void main(String[] args) {

      BuildBinaryTree sol = new BuildBinaryTree();

      int[] inorder = {9, 3, 15, 20, 7};
      int[] postorder = {9, 15, 7, 20, 3};

      TreeNode treeNode = sol.buildTree(inorder, postorder);

      System.out.println(treeNode);
   }


   public TreeNode buildTree(int[] inorder, int[] postorder) {

      if (inorder == null || postorder == null || inorder.length == 0
            || inorder.length != postorder.length) {
         return null;
      }

      Map<Integer, Integer> idxMap = new HashMap<>();

      for (int i = 0; i < inorder.length; i++) {
         idxMap.put(inorder[i], i);
      }

      return buildTreeRecur(inorder, 0, inorder.length - 1, postorder, idxMap);
   }

   private TreeNode buildTreeRecur(int[] inorder, int l, int r, int[] postorder,
         Map<Integer, Integer> idxMap) {

      if (postorder.length == 0) {
         return null;
      }
      if (postorder.length == 1) {
         return new TreeNode(postorder[postorder.length - 1]);
      }

      TreeNode root = new TreeNode(postorder[postorder.length - 1]);
      Deque<TreeNode> s = new LinkedList<>();
      s.push(root);
      TreeNode cur;

      /*
         int[] inorder = {9, 3, 15, 20, 7};
         int[] postorder = {9, 15, 7, 20, 3};
       */

      for (int i = postorder.length - 2, j = inorder.length - 1; i >= 0; i--) {

         cur = s.peek();

         if (cur.val != inorder[j]) {

            cur.right = new TreeNode(postorder[i]);
            cur = cur.right;
            s.push(cur);

         } else {

            while (!s.isEmpty() && inorder[j] == s.peek().val) {
               cur = s.pop();
               j--;
            }

            cur.left = new TreeNode(postorder[i]);
            cur = cur.left;
            s.push(cur);

         }
      }

      return root;
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