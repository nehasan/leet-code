import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeInorder {
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

    public void inorder(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            inorder(node.left, nodeList);
            nodeList.add(node.val);
            inorder(node.right, nodeList);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        inorder(root, nodeList);

        return nodeList;
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
        System.out.println(Arrays.toString(inorderTraversal(root).toArray()));
    }

    public static void main (String[] args) {
        BinaryTreeInorder btLot = new BinaryTreeInorder();
        btLot.func();
    }
}
