/**
 * @param {string} str
 * time:O(n), n is input string length
 * space:O(128)=O(1)
 */
function isUnique(str) {
    // Assume it's a ASCII string
    // We first create a map to record the chars in this array
    let m = new Array(128).fill(0);
    for (let i = 0; i < str.length; i++) {
        m[str.charCodeAt(i)] += 1;
        if (m[str.charCodeAt(i)] > 1) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} str
 */
function isU(str) {
    // Use bits to check uniqueness
    // GOTCHA: Only valid for 32 bits because bit operator can only manipulate 32 bits
    let checker = 0;
    for (let i = 0; i < str.length; i++) {
        let val = str.charCodeAt(i) - 'a'.charCodeAt(0);
        if ((checker & (1 << val)) > 0) {
            return false;
        }
        checker |= (1 << val);
    }
    return true;
}