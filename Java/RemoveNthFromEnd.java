import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int size = 0;
        Map<Integer, ListNode> nodeMap = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            size++;
            nodeMap.put(size, curr);
            curr = curr.next;
        }

//        System.out.println("SIZE: " + size);

        int nth = size - n;
//        System.out.println("NTH: " + nth);

        if (nth == 0) {
            head = head.next;
//            print(head);
            return head;
        }

        if (nth == (size - 1)) {
            nodeMap.get(nth).next = null;
        } else {
            nodeMap.get(nth).next = nodeMap.get(nth + 2);
        }

//        print(head);
        return head;

    }

    public void func() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        removeNthFromEnd(head, 5);
    }

    public static void main (String[] args) {
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        obj.func();
    }
}
