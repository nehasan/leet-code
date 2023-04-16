import com.sun.source.tree.Tree;

import java.util.*;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void inorderTraverse(TreeNode node) {
            if (node != null) {
                System.out.print(node.val + " ");
                inorderTraverse(node.left);
                inorderTraverse(node.right);
            }
        }

        public void printInorder() {
            inorderTraverse(this);
        }
    }

    public String decimalToBinary(int n) {
        int m = n;
        char[] binChars = new char[12];
        Arrays.fill(binChars, '0');
        int index = 11;

        n = Math.abs(n);
        do {
            int rem = n % 2;
            n = n / 2;
            binChars[index--] = Integer.toString(rem).charAt(0);
        } while(n > 0);

        if (m < 0) {
            binChars[0] = '1';
        }

        return String.valueOf(binChars);
    }

    public int binaryToDecimal(String s) {
        if (s.equals("000000000000")) {
            return 0;
        }
        String tempS = s.substring(1, s.length());
        int decimal = Integer.parseInt(tempS, 2);
        if (s.charAt(0) == '1') {
            decimal = 0 - decimal;
        }
        return decimal;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = new String("");
        if (root == null) {
            return new String("111111111111");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        s = s.concat(decimalToBinary(root.val));

        while (!queue.isEmpty()) {
            int q_size = queue.size();
            for (int i = 0; i < q_size; i++) {
                TreeNode currentNode = queue.remove();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    s = s.concat(decimalToBinary(currentNode.left.val));
                } else {
                    s+= "111111111111";
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    s = s.concat(decimalToBinary(currentNode.right.val));
                } else {
                    s+= "111111111111";
                }
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int beg = 0, end = 11;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();
        String s = data.substring(beg, end + 1);
        queue1.add(s);
        if (s.equals("111111111111")) {
            return null;
        }
        TreeNode root = new TreeNode(-100001);
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode current = queue.remove();
                String nodeVal = queue1.remove();
                current.val = binaryToDecimal(nodeVal);
                beg += 12;
                end += 12;
                String left = data.substring(beg, end + 1);
                beg += 12;
                end += 12;
                String right = data.substring(beg, end + 1);
                if (left.equals("111111111111")) {
                    current.left = null;
                } else {
                    TreeNode leftNode = new TreeNode(-100001);
                    current.left = leftNode;
                    queue.add(leftNode);
                    queue1.add(left);
                }

                if (right.equals("111111111111")) {
                    current.right = null;
                } else {
                    TreeNode rightNode = new TreeNode(-100001);
                    current.right = rightNode;
                    queue.add(rightNode);
                    queue1.add(right);
                }
            }
        }
        return root;
    }

    public void func() {
        TreeNode root;
//        root = null;
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
//        System.out.println(serialize(root));
        TreeNode r = deserialize(serialize(root));
        r.printInorder();
    }

    public static void main (String[] args) {
        Codec codec = new Codec();
//        System.out.println(codec.decimalToBinary(10));
//        System.out.println(codec.decimalToBinary(6));
//        System.out.println(codec.decimalToBinary(2));
//        System.out.println(codec.decimalToBinary(0));
        codec.func();
    }
}
