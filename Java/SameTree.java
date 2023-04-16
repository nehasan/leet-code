import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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

    public void enqueuePTree(Queue<Integer> nodeList, TreeNode node) {
        if (node == null) {
            nodeList.add(Integer.MIN_VALUE);
        } else {
            nodeList.add(node.val);
            enqueuePTree(nodeList, node.left);
            enqueuePTree(nodeList, node.right);
        }
    }

    public boolean checkQTree(Queue<Integer> nodeList, TreeNode node) {
        if (node == null) {
            if (!nodeList.isEmpty() && nodeList.peek() != Integer.MIN_VALUE) {
                return false;
            }
            nodeList.remove();
            return true;
        } else {
            if (!nodeList.isEmpty() && (nodeList.peek() != node.val)) {
                return false;
            }
            nodeList.remove();
            return checkQTree(nodeList, node.left) && checkQTree(nodeList, node.right);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Integer> nodeList = new LinkedList<>();
        enqueuePTree(nodeList, p);
        checkQTree(nodeList, q);
        return nodeList.isEmpty();
    }

    public void func() {
//        TreeNode p, q;
        TreeNode p = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(isSameTree(p, q));

        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(isSameTree(p, q));

        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree(p, q));
    }

    public static void main (String[] args) {
        SameTree st = new SameTree();
        st.func();
    }
}
