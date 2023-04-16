import java.util.*;

public class LowestCommonAncestor236 {
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

    // DFS traversal to track the visited node to reach to the targeted node p / q
    public void findLowestCommonAncestor(TreeNode node, TreeNode target,
                                         Stack<Integer> ancestors,
                                         List<Integer> list, HashMap<Integer, TreeNode> _nodeHashMap) {
        if (node != null) {
            // Once target is found then push the last target to stack and
            // Store all the stack elements (current visited path) to a list
            if (node == target) {
                ancestors.push(node.val);
                _nodeHashMap.put(node.val, node);
                list.addAll(ancestors);
            } else {
                // Push a current node value to the stack for tracking current path
                ancestors.push(node.val);
                _nodeHashMap.put(node.val, node);
                findLowestCommonAncestor(node.left, target, ancestors, list, _nodeHashMap);
                findLowestCommonAncestor(node.right, target, ancestors, list, _nodeHashMap);
                // Reaching here means the path did not find the target
                // So we need to remove the current visited node from the stack
                ancestors.pop();
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Integer> ancestorsP = new Stack<>();
        Stack<Integer> ancestorsQ = new Stack<>();
        List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();
        HashMap<Integer, TreeNode> nodeHashMap = new HashMap<>();

        // DFS traverse the tree and follow the path to find the target
        // Once target is found then store the current path to a list for further processing
        findLowestCommonAncestor(root, p, ancestorsP, listP, nodeHashMap);
        findLowestCommonAncestor(root, q, ancestorsQ, listQ, nodeHashMap);

        int commonAncestor = Integer.MIN_VALUE;
        for (int i = listP.size() - 1; i >= 0; i--) {
            for (int j = listQ.size() - 1; j >= 0; j--) {
                if (listP.get(i).equals(listQ.get(j))) {
                    commonAncestor = listP.get(i);
                    break;
                }
            }
            if (commonAncestor != Integer.MIN_VALUE) break;
        }

        return nodeHashMap.get(commonAncestor);
    }

    public void func() {
        //tree [[3,5,1,6,2,0,8,null,null,7,4]]
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))
                ),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        //tree [6,2,8,0,4,7,9,null,null,3,5]
        /*root = new TreeNode(
                6,
                new TreeNode(
                        2,
                        new TreeNode(0),
                        new TreeNode(4, new TreeNode(3), new TreeNode(5))
                ),
                new TreeNode(8, new TreeNode(7), new TreeNode(9))
        );*/

//        root = new TreeNode(2, new TreeNode(1), null);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }

    public static void main (String[] args) {
        LowestCommonAncestor236 obj = new LowestCommonAncestor236();
        obj.func();
    }
}
