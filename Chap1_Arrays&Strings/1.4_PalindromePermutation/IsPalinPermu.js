/**
 * @param {string} str
 * @returns {boolean}
 * time:O(n), n is the string length
 * space:O(128+1) = O(1)
 */
function isPalinPermu(str) {
    let oddCnt = 0;
    // Build a map (Assume it's a ASCII string)
    let m = new Array(128).fill(0);
    for (let i = 0; i < str.length; i++) {
        m[str.charCodeAt(i)]++;
    }
    // Check if odd count is larger than 1
    for (let val of m) {
        if (val % 2 === 1) {
            oddCnt++;
            if (oddCnt > 1) {
                return false;
            }
        }
    }
    return true;
}

function test() {
    console.log(isPalinPermu("aaa") === true);
    console.log(isPalinPermu("aaaa") === true);
    console.log(isPalinPermu("abababab" === true));
    console.log(isPalinPermu("_><_") === false);
    console.log(isPalinPermu("123") === false);
}