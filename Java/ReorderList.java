import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderList {
    class ListNode {
        public int data;
        public ListNode next;

        public ListNode() {
            data = 0;
            next = null;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public void print(ListNode node) {
        ListNode curr = node;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public ListNode reorderList(ListNode head) {
        if (head == null) return null;
        int size = 0;
        Map<Integer, ListNode> nodeMap = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            size++;
            nodeMap.put(size, curr);
            curr = curr.next;
        }

//        System.out.println(size);

        if (size == 1 || size == 2) {
//            print(head);
            return head;
        } else {
            int i = 1, j = size;
            while (i <= size/ 2) {
//                System.out.println("HERE 1: " + i);
                nodeMap.get(i).next = nodeMap.get(j);
                nodeMap.get(j).next = nodeMap.get(i + 1);
                i++;
                j--;
            }
//            System.out.println("HERE: " + i);
            nodeMap.get(i).next = null;
        }

//        print(head);
        return head;

    }

    public void func() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        reorderList(head);
    }

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        obj.func();
    }
}
