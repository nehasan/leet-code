import com.sun.source.tree.Tree;

import java.util.*;

public class BTLevelOrderTraversal {
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

    /*
    * Solution using array list index
    * ---------- start --------------
    * Normal arraylist index fashion where we pass in the level (current height) of the nodes
    * Later we access the index array list from listOfNodeList as nodeList, and we put the node val
    * */
    public void levelOrderTraversal(TreeNode node, int level, List<List<Integer>> listOfNodeList) {
       if (node != null) {
           try {
               List<Integer> nodeList = listOfNodeList.get(level);
               nodeList.add(node.val);
           } catch (Exception ex) {
               List<Integer> nodeList = new ArrayList<>();
               nodeList.add(node.val);
               listOfNodeList.add(nodeList);
           }
           levelOrderTraversal(node.left, level + 1, listOfNodeList);
           levelOrderTraversal(node.right, level + 1, listOfNodeList);
       }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listOfNodeList = new ArrayList<>();
        levelOrderTraversal(root, 0, listOfNodeList);
        return listOfNodeList;
    }
    /*
    * Solution using array list index
    * --------- end -----------------
    * */

    /*
    * BFS solution
    * ------ start ------
    */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> listOfNodeList = new ArrayList<>();
        if (root == null) {
            return listOfNodeList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int q_size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < q_size; i++) {
                TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            listOfNodeList.add(currentLevel);
        }
        return listOfNodeList;
    }
    /*
     * BFS solution
     * ------ end ---------
     */

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
//        List<List<Integer>> listOfNodeList = levelOrder(root);
        List<List<Integer>> listOfNodeList = levelOrder1(root);
        System.out.println(Arrays.toString(listOfNodeList.toArray()));
    }

    public static void main (String[] args) {
        BTLevelOrderTraversal btLot = new BTLevelOrderTraversal();
        btLot.func();
    }
}
