import com.sun.source.tree.Tree;

import java.util.Arrays;

public class IsSameTree {
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

    public boolean isSameNode (TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        } else if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (isSameNode(p, q)) {
            return true;
        }

        return false;
    }

    public void func() {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), new TreeNode( 3, null, null));
        TreeNode q = new TreeNode(1, new TreeNode(2, null, null), new TreeNode( 3, null, null));

        p = new TreeNode(1, new TreeNode(2, null, null), null);
        q = new TreeNode(1, null, new TreeNode(2, null, null));

        System.out.println(isSameTree(p, q));
    }

    public static void main (String[] args) {
        IsSameTree sb = new IsSameTree();
        sb.func();
    }
}
