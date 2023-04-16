public class BTMaxPathSum {
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

    public int pathSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, pathSum(node.left, maxSum));
        int rightSum = Math.max(0, pathSum(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], (leftSum + rightSum + node.val));
        return Math.max(leftSum, rightSum) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{ Integer.MIN_VALUE };
        pathSum(root, maxSum);
        return maxSum[0];
    }

    public void func() {
        TreeNode root;
//        root = new TreeNode(
//                1,
//                new TreeNode(1),
//                new TreeNode(2)
//        );
//        System.out.println(maxPathSum(root));
        root = new TreeNode(
                -10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(maxPathSum(root));
    }
    public static void main(String[] args) {
        BTMaxPathSum m = new BTMaxPathSum();
        m.func();
    }
}
