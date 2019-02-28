/**
 * @param {string} str1
 * @param {string} str2
 */
function isPermutation(str1, str2) {
    // Small optimization (check length first)
    if (str1.length !== str2.length) {
        return false;
    }
    // Assume it's a ASCII string
    let m = new Array(128).fill(0);
    // Build map by str1
    for (let i = 0; i < str1.length; i++) {
        m[str1.charCodeAt(i)]++;
    }
    // Use map to check str2
    for (let i = 0; i < str2.length; i++) {
        m[str2.charCodeAt(i)]--;
        if (m[str2.charCodeAt(i)] < 0) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} str1
 * @param {string} str2
 */
function isPermu(str1, str2) {
    // Small optimization (check length first)
    if (str1.length !== str2.length) {
        return false;
    }
    let sort1 = str1.split("").sort().join("");
    let sort2 = str2.split("").sort().join("");
    for (let i = 0; i < sort1.length; i++) {
        if (sort1.charAt(i) !== sort2.charAt(i)) {
            return false;
        }
    }
    return true;
}

function runTest() {
    console.log("test set1");
    console.log(isPermutation("123", "321"));
    console.log(isPermutation("666", "66"));
    console.log(isPermutation("55", "66"));
    console.log(isPermutation("ab123", "321ba"));
    // console.log(isPermutation("我是你", "你是我"));should fail since it's UTF-8

    console.log("---");

    console.log("test set2");
    console.log(isPermu("123", "321"));
    console.log(isPermu("666", "66"));
    console.log(isPermu("55", "66"));
    console.log(isPermu("ab123", "321ba"));
    console.log(isPermu("我是你", "你是我"));
}