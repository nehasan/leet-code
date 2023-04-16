import java.util.*;

public class CourseSchedule {
    public class Node {
        public int val;
        public List<Node> edges;
        public Node () {
            val = 0;
            edges = new ArrayList<>();
        }
        public Node (int _val) {
            val = _val;
            edges = new ArrayList<>();
        }
    }

    public boolean isCyclic(Node node, Stack<Integer> visitedMap) {
        int size = node.edges.size();
        for (int i = 0; i < size; i++) {
            Node edge = node.edges.get(i);
            if (visitedMap.contains(edge.val)) {
                return true;
            } else {
                visitedMap.push(edge.val);
                if (isCyclic(edge, visitedMap)) return true;
            }
        }

        if (!visitedMap.isEmpty()) visitedMap.pop();
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<>();
        List<Integer> nodeValues = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (nodes.containsKey(prerequisites[i][1])) {
                if (nodes.containsKey(prerequisites[i][0])) {
                    nodes.get(prerequisites[i][1]).edges.add(nodes.get(prerequisites[i][0]));
                } else {
                    Node newEdge = new Node(prerequisites[i][0]);
                    nodes.put(newEdge.val, newEdge);
                    nodes.get(prerequisites[i][1]).edges.add(newEdge);
                    nodeValues.add(newEdge.val);
                }
            } else {
                Node newNode = new Node(prerequisites[i][1]);
                if (nodes.containsKey(prerequisites[i][0])) {
                    newNode.edges.add(nodes.get(prerequisites[i][0]));
                } else {
                    Node newEdge = new Node(prerequisites[i][0]);
                    nodes.put(newEdge.val, newEdge);
                    newNode.edges.add(newEdge);
                    nodeValues.add(newEdge.val);
                }
                nodes.put(newNode.val, newNode);
                nodeValues.add(newNode.val);
            }
        }

        if (nodes.isEmpty()) return true;

        for (int i = 0; i < nodeValues.size(); i++) {
            Node n = nodes.get(nodeValues.get(i));
            Stack<Integer> visitedNodes = new Stack<>();
            visitedNodes.push(n.val);
            if (isCyclic(n, visitedNodes)) return false;
        }

        return true;
    }

    public boolean isCyclic2(int n, Map<Integer, List<Integer>> nodesMap, Stack<Integer> visitedNodes) {
        if (visitedNodes.contains(n)) return true;

        int size = nodesMap.get(n).size();
        List<Integer> edges = nodesMap.get(n);
        visitedNodes.push(n);

        for (int i = 0; i < size; i++) {
            int edge = edges.get(i);
            if (isCyclic2(edge, nodesMap, visitedNodes)) return true;
        }

        if (edges.size() > 0) {
            edges.remove(edges.size() - 1);
            nodesMap.put(n, edges);
        }
        if (!visitedNodes.isEmpty()) visitedNodes.pop();
        return false;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nodesMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int nodeVal = prerequisites[i][0];
            int edgeVal = prerequisites[i][1];
            List<Integer> edges;

            if (nodesMap.containsKey(nodeVal)) {
                edges = nodesMap.get(nodeVal);
                if (!nodesMap.containsKey(edgeVal)) {
                    nodesMap.put(edgeVal, new ArrayList<>());
                }
            } else {
                edges = new ArrayList<>();
            }

            edges.add(edgeVal);
            nodesMap.put(nodeVal, edges);

            if (!nodesMap.containsKey(edgeVal)) {
                nodesMap.put(edgeVal, new ArrayList<>());
            }
        }

        if (nodesMap.isEmpty()) return true;

        for (int i = 0; i < numCourses; i++) {
            if (nodesMap.containsKey(i)) {
                Stack<Integer> visitedNodes = new Stack<>();
                if (isCyclic2(i, nodesMap, visitedNodes)) return false;
            }
        }

        return true;
    }

    public void func() {
        int[][] prerequisites = new int[][]{{1,0}, {0, 1}};
//        prerequisites = new int[][]{{1,0}};
//        prerequisites = new int[][]{};
//        prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
//        prerequisites = new int[][]{{0,10},{3,18},{5,5}};
//        prerequisites = new int[][]{{1,0},{1,2},{0,1}};
        prerequisites = new int[][]{{2,0},{2,1}};
//        System.out.println(canFinish(1, prerequisites));
        System.out.println(canFinish2(3, prerequisites));
    }

    public static void main (String[] args) {
        CourseSchedule cs = new CourseSchedule();
        cs.func();
    }
}
