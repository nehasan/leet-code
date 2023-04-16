import com.sun.source.tree.Tree;

public class IsSubTree {
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

    public boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val == q.val) {
                return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
            }
            return false;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return false;
    }

    public void func() {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null)), new TreeNode( 5, null, null));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1, null, null), new TreeNode( 2, null, null));

        root = new TreeNode(1, new TreeNode(1, null, null), null);
        subRoot = new TreeNode(1, null, null);
        System.out.println(isSubtree(root, subRoot));
    }

    public static void main (String[] args) {
        IsSubTree sb = new IsSubTree();
        sb.func();
    }
}
