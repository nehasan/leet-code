import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
//    Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public void inorderTraverse(TreeNode node) {
          if (node != null) {
              System.out.print(node.val + " ");
              inorderTraverse(node.left);
              inorderTraverse(node.right);
          }
      }

      public void printInorder() {
          inorderTraverse(this);
      }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public void func() {
        TreeNode root;
//        root = new TreeNode(
//                4,
//                new TreeNode(2),
//                new TreeNode(
//                        7,
//                        new TreeNode(6),
//                        new TreeNode(9)
//                )
//        );
//        root = invertTree(root);
//        root.printInorder();

        root = new TreeNode(
                1,
                new TreeNode(2),
                null
        );

        root = invertTree(root);
        root.printInorder();
    }

    public static void main (String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        ibt.func();
    }
}
