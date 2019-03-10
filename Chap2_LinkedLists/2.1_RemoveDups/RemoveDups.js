/**
 * @param {number} v
 */
function Node(v) {
    this.val = v;
    this.next = null;
}

/**
 * @param {Node} head
 * @returns {Node}
 * time:O(n), we traverse the linked list with n elements
 * space:O(n), we make a set with potential size n
 */
function removeDups(head) {
    if (!head) {
        return head;
    }
    let s = [head.val];
    let cur = head;
    while (cur.next) {
        if (s.includes(cur.next.val)) {
            cur.next = cur.next.next;
        } else {
            s.push(cur.val);
            cur = cur.next;
        }
    }
    return head;
}

/**
 * param {Node} head
 * @returns {void}
 * we use a runner pointer to check all future nodes
 * time:O(n^2), n is the length of the linked list
 * space:O(1)
 */
function removeDupsSpace1(head) {
    let cur = head;
    while (cur) {
        let runner = cur;
        while (runner.next) {
            if (runner.next.val === cur.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        cur = cur.next;
    }
}

function test() {
    let h = makeLL([1, 2, 3, 4, 5, 6, 1, 2]);
    printLL(h);
    removeDups(h);
    printLL(h);
    h = makeLL([1, 2, 3, 4, 5, 6, 1, 2]);
    printLL(h);
    removeDupsSpace1(h);
    printLL(h);
}

/**
 * @param {number[]} arr
 * @returns {Node}
 */
function makeLL(arr) {
    if (!arr || arr.length < 0) {
        return null;
    }
    let head = new Node(arr[0]);
    let cur = head;
    for (let i = 1; i < arr.length; i++) {
        cur.next = new Node(arr[i]);
        cur = cur.next;
    }
    return head;
}

/**
 * @param {Node} h
 * @returns {void}
 */
function printLL(h) {
    if (!h) {
        return;
    }
    let out = "";
    while (h) {
        out += h.val + "->";
        h = h.next;
    }
    console.log(out + "x");
}