/**
 * @param {string} str
 * @returns {string}
 * time:O(n), n is the string length
 * space:O(n)
 */
function compressStr(str) {
    // zero check
    if (str.length < 2) {
        return str;
    }
    let ret = "";
    let letter = str.charAt(0),
        repeat = 1;
    for (let i = 1; i < str.length; i++) {
        if (str.charAt(i) === str.charAt(i - 1)) {
            repeat++;
        } else {
            ret += letter + repeat;
            letter = str.charAt(i);
            repeat = 1;
        }
    }
    ret += letter + repeat;
    return ret.length < str.length ? ret : str;
}

function test() {
    console.log(compressStr("aabbABABAB"));
    console.log(compressStr("aabbcccc"));
    console.log(compressStr("aabbccccAABCCC"));
}