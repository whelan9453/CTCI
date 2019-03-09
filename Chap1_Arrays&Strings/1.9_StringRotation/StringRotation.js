/**
 * @param {string} str1
 * @param {string} str2
 * @returns {boolean}
 * time:O(n^2), n is the string length. We loop n times and each time we need O(n) time to copy the string
 * space:O(n), we make a temp string with length n in the for loop
 */
function isRotation(str1, str2) {
    if (str1.length !== str2.length) {
        return false;
    }
    if (str1 === str2) {
        return true;
    }
    for (let i = 0; i < str1.length; i++) {
        let temp = str1.slice(i + 1) + str1.slice(0, i + 1);
        if (temp === str2) {
            return true;
        }
    }
    return false;
}

function test() {
    console.log(isRotation("abc", "abc"));
    console.log(isRotation("abc", "abcd"));
    console.log(isRotation("abc", "bca"));
    console.log(isRotation("abc", "cab"));
}