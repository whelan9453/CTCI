class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // we traverse the linked list to get the length and get the kth to the last
    // time:O(n+k) = O(n), n is ll length and k is k
    // space:O(1)
    static Node returnKthToLast(Node head, int k) {
        Node cur = head;
        int c = 0;
        while (cur != null) {
            cur = cur.next;
            c++;
        }
        if (c - k < 0) {
            return null;
        }
        cur = head;
        for (int i = 0; i < c - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // we use two pointers
    // fast one first travels k and is (l-k)th to the last
    // slow one then travels along with the fast one until the fast one reach the
    // end, so the slow one moves (l-k) from the start, hence k to the last
    // time:O(k + (l-k)) = O(l), l is the ll length
    // space:O(1)
    static Node returnKthToLastSmart(Node head, int k) {
        Node fast = head;
        Node slow = head;
        // move the fast pointer to (l-k)th to the last
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        // move the slow one along with the fast one until the fast one reach the end
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class Node {
    int val;
    Node next;

    public Node(int v) {
        this.val = v;
    }
}