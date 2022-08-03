package com.algs.tree;

import com.algs.tree.DeleteNodeInBST.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCAOfBT {

   public static void main(String[] args) {

      LCAOfBT lca = new LCAOfBT();

      // [5,3,6,2,4,null,7]

      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(7);

      System.out.println(lca.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(6)).val);

   }

   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      Map<Integer, Set<Integer>> subtreeResult = new HashMap<>();

      return lowestCommonAncestorInternal(root, p, q, subtreeResult);
   }

   private TreeNode lowestCommonAncestorInternal(TreeNode root, TreeNode p, TreeNode q,
         Map<Integer, Set<Integer>> subtreeResult) {
      if (root == null) {
         return null;
      }

      Set<Integer> leftVals = new HashSet<>();
      Set<Integer> rightVals = new HashSet<>();
      if (root.left != null) {
         TreeNode left = lowestCommonAncestorInternal(root.left, p, q, subtreeResult);
         if (left != null) {
            return left;
         }
         leftVals = subtreeResult.get(root.left.val);
      }

      if (root.right != null) {
         TreeNode right = lowestCommonAncestorInternal(root.right, p, q, subtreeResult);
         if (right != null) {
            return right;
         }

         rightVals = subtreeResult.get(root.right.val);
      }

      Set<Integer> foundVals = getFoundValues(subtreeResult, root.val);
      foundVals.addAll(leftVals);
      foundVals.addAll(rightVals);

      if (root.val == p.val) {
         foundVals.add(root.val);
      }
      else if (root.val == q.val) {
         foundVals.add(root.val);
      }

      if (foundVals.size() == 2) {
         return root;
      } else {
         return null;
      }
   }

   private Set<Integer> getFoundValues(Map<Integer, Set<Integer>> subtreeResult, int val) {
      Set<Integer> foundVals = subtreeResult.get(val);
      if (foundVals == null) {
         foundVals = new HashSet<>();
         subtreeResult.put(val, foundVals);
      }
      return foundVals;
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
