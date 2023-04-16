import java.util.Arrays;
import java.util.HashMap;

// Leetcode 105: Construct binary tree from given preorder and inorder traversal
public class BuildTreePreNInOrder {
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

    int preorderIndex;
    HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTreeFromArray(int[] preorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) return null;

        TreeNode root = new TreeNode();
        // always get the first value of preorder as root
        int rootValue = preorder[preorderIndex++];
        // get the index of the root element from inorder hash map
        // this will need to process for the next recursive call
        int rootIndexInInorder = inorderIndexMap.get(rootValue);

        root.val = rootValue;
        root.left = buildTreeFromArray(preorder, leftIndex, rootIndexInInorder - 1);
        root.right = buildTreeFromArray(preorder, rootIndexInInorder + 1, rightIndex);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeFromArray(preorder, 0, inorder.length - 1);
    }

    public void printTreeInorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printTreeInorder(root.left);
            printTreeInorder(root.right);
        }
    }

    public void func() {
        int[] preorder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
        int[] inorder = new int[] { 4, 2, 5, 1, 6, 3, 7 };

        printTreeInorder(buildTree(preorder, inorder));
    }

    public static void main (String[] args) {
        BuildTreePreNInOrder sb = new BuildTreePreNInOrder();
        sb.func();
    }
}
