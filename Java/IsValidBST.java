import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode () {}
        public TreeNode (int val) {
            this.val = val;
        }
        public TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // In valid BST the inorder traversal would be always left < node < right
    // Any previous node key in this traversal less than the current node key makes invalid BST
    // Example inorder 4, 5, 3, 6, 7 | original tree: 5, 4, null, null, 6, 3, null, null, 7, null, null
    // recursive inorder traversal and continuously check prev node value to validate a BST

    public boolean validate(TreeNode node, Stack<Integer> inorderTraversal) {
        if (node != null) {
            if (!validate(node.left, inorderTraversal)) {
                return false;
            }
            if (!inorderTraversal.isEmpty() && node.val <= inorderTraversal.peek()) {
                return false;
            }
            System.out.println("BEFORE: " + Arrays.toString(inorderTraversal.toArray()));
            inorderTraversal.push(node.val);
            System.out.println("AFTER: " + Arrays.toString(inorderTraversal.toArray()));
            return validate(node.right, inorderTraversal);
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<Integer> inorderTraversal = new Stack<>();
        return validate(root, inorderTraversal);
    }

    public void func() {
        TreeNode tree = new TreeNode(
                2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null)
        );

        tree = new TreeNode(
                1,
                null,
                new TreeNode(1, null, null)
        );

//        tree = new TreeNode(
//                5,
//                new TreeNode(4, null, null),
//                new TreeNode(
//                        6,
//                        new TreeNode(3, null, null),
//                        new TreeNode(7, null, null)
//                )
//        );

//        tree = new TreeNode(
//                5,
//                new TreeNode(1, null, null),
//                new TreeNode(
//                        4,
//                        new TreeNode(3, null, null),
//                        new TreeNode(7, null, null)
//                )
//        );

        System.out.println(isValidBST(tree));
    }

    public static void main (String[] args) {
        IsValidBST sb = new IsValidBST();
        sb.func();
    }
}
