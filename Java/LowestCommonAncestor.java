import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class LowestCommonAncestor {
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

    // Search for proper BST node that matches the BST rule node.left < node.val < node.right
    // If node value is > p value and node value is > q value search in the left BST
    // Opposite is true then search in the right BST
    // Else return current node
    public TreeNode findLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        } else {
            if (node.val > p.val && node.val > q.val) {
                return findLowestCommonAncestor(node.left, p, q);
            } else if (node.val < p.val && node.val < q.val) {
                return findLowestCommonAncestor(node.right, p, q);
            } else {
                return node;
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root, p, q);
    }

    public void func() {
        //tree [6, 4, 7, 2, 5, nul, null]
        TreeNode root = new TreeNode(
                6,
                new TreeNode(
                        4,
                        new TreeNode(2),
                        new TreeNode(5)
                ),
                new TreeNode(7));

        //tree [6,2,8,0,4,7,9,null,null,3,5]
        root = new TreeNode(
                6,
                new TreeNode(
                        2,
                        new TreeNode(0),
                        new TreeNode(4, new TreeNode(3), new TreeNode(5))
                ),
                new TreeNode(8, new TreeNode(7), new TreeNode(9))
        );

//        root = new TreeNode(2, new TreeNode(1), null);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
    }

    public static void main (String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();
        obj.func();
    }
}
