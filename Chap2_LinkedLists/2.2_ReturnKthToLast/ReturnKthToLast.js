/**
 * @param {Node} h
 * @param {number} k
 * @returns {Node}
 * time:O(l-k+k) = O(l), l is the ll length
 * space:O(1)
 */
function returnKthToLast(h, k) {
    let slow = h;
    let fast = h;
    // move fast to (n-k)th from the last
    for (let i = 0; i < k && fast; i++) {
        fast = fast.next;
    }
    // move the slow pointer along with the fast pointer 
    while (slow && fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}

class Node {
    constructor(v) {
        this.val = v;
        this.next = null;
    }
}