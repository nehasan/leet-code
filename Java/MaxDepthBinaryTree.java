public class MaxDepthBinaryTree {
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
    }

    public int findMaxDepth(TreeNode node, int height) {
        if (node == null) {
            return height;
        } else {
            int heightR = findMaxDepth(node.right, height + 1);
            int heightL = findMaxDepth(node.left, height + 1);
            return Math.max(heightL, heightR);
        }
    }

    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 1);
    }

    public void run() {
        TreeNode root = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        System.out.println(maxDepth(root));
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree obj = new MaxDepthBinaryTree();
        obj.run();
    }
}
