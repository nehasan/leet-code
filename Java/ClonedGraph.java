import java.util.*;

public class ClonedGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Node _node = new Node(1);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(1, _node);

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> _queue = new LinkedList<>();
        queue.add(node);
        _queue.add(_node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node n = queue.remove();
                Node _n = _queue.remove();

                if (!map.containsKey(n.val)) {
                    map.put(n.val, n.val);

                    int neighborSize = n.neighbors.size();
                    for (int j = 0; j < neighborSize; j++) {
                        Node neighbor = n.neighbors.get(j);
                        queue.add(neighbor);

                        if (nodeMap.containsKey(neighbor.val)) {
                            Node neighborNode = nodeMap.get(neighbor.val);
                            _n.neighbors.add(neighborNode);
                            _queue.add(neighborNode);
                        } else {
                            Node neighborNode = new Node(neighbor.val);
                            nodeMap.put(neighbor.val, neighborNode);
                            _n.neighbors.add(neighborNode);
                            _queue.add(neighborNode);
                        }
                    }
                }
            }
        }

        return _node;
    }

    public void func() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node _node = cloneGraph(node1);
        System.out.println(_node);
    }

    public static void main (String[] args) {
        ClonedGraph sb = new ClonedGraph();
        sb.func();
    }
}
