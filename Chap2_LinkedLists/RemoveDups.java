import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Node h = makeLL(new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 1 });
        printLL(h);
        removeDups(h);
        printLL(h);
        h = makeLL(new int[] { 3, 8, 1, 2, 3, 4, 5, 6, 6, 6, 611 });
        printLL(h);
        removeDups(h);
        printLL(h);
        h = makeLL(new int[] { 3, 3, 4, 5, 6, 7, 8, 1, 2, 3, 66, 7, 8 });
        printLL(h);
        removeDupsSpace1(h);
        printLL(h);
    }

    // Make a HashSet as a buffer and traverse LinkedList to check duplicates and
    // remove them
    // time:O(n), n is the length of the linked list (if s.contains is O(1))
    // space:O(n), we build a set which is at most as long as the linked list
    static Node removeDups(Node head) {
        if (head == null) {
            return head;
        }
        Set<Integer> s = new HashSet<>();
        s.add(head.val);
        Node cur = head;
        while (cur.next != null) {
            if (s.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                s.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }

    // We don't use extra space to record the duplicate elements
    // We use a runner to check all future elements and skip duplicate ones
    // time:O(n^2)
    // space:O(1)
    static Node removeDupsSpace1(Node head) {
        Node cur = head;
        while (cur != null) {
            Node runner = cur;
            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    static Node makeLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    static void printLL(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.print("x\n");
    }
}

class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
    }
}