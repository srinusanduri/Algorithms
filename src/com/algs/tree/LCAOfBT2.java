package com.algs.tree;

public class LCAOfBT2 {

   public static void main(String[] args) {

      LCAOfBT2 lca = new LCAOfBT2();

      // [5,3,6,2,4,null,7]

      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);

      System.out.println(lca.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);

   }

   private TreeNode lcaNode = null;

   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      lca(root, p, q);
      return lcaNode;
   }

   public boolean lca(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
         return false;
      }

      boolean isMatch = false;
      if (root.val == p.val || root.val == q.val) {
         isMatch = true;
      }

      boolean isLeftMatch = lca(root.left, p, q);

      if (isMatch && isLeftMatch) {
         lcaNode = root;
         return true;
      }

      boolean isRightMatch = lca(root.right, p, q);

      if ((isMatch && isRightMatch) || (isLeftMatch && isRightMatch)) {
         lcaNode = root;
         return true;
      }

      if (isMatch || isLeftMatch || isRightMatch) {
         return true;
      }
      else{
         return false;
      }
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
