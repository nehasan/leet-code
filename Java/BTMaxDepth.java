public class BTMaxDepth {
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
            return height - 1;
        } else {
            int heightR = findMaxDepth(node.right, height + 1);
            int heightL = findMaxDepth(node.left, height + 1);
            return Math.max(heightL, heightR);
        }
    }

    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 1);
    }

    public void func() {
        TreeNode node1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(5, node1, node2);
        System.out.println(maxDepth(root));

        root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(maxDepth(root));
    }

    public static void main(String[] args) {
        BTMaxDepth m = new BTMaxDepth();
        m.func();
    }
}
