/**
 * @param {string} str1
 * @param {string} str2
 * @returns {boolean} 
 * 
 * time:O(n), n is longer string length
 * space:O(n), copy strings
 */
function oneAway(str1, str2) {
    // optimization: check two or more away
    if (Math.abs(str1.length - str2.length) > 1) {
        return false;
    }
    // check replace (same length)
    if (str1.length === str2.length) {
        let diff = 0;
        for (let i = 0; i < str1.length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (diff++ > 1) {
                    return false;
                }
            }
        }
    }
    // check insert/remove (put longer string to str1)
    if (str1.length < str2.length) {
        let temp = str1;
        str1 = str2;
        str2 = temp;
    }
    let diff = 0;
    let i = 0, j = 0;
    while (i < str1.length && j < str2.length) {
        if (str1.charAt(i) !== str2.charAt(j)) {
            if (diff++ > 1) {
                return false;
            }
            j++;
            continue;
        }
        i++;
        j++
    }
    return true;
}

function test() {
    console.log(oneAway("123", "123") === true);
    console.log(oneAway("123", "1234") === true);
    console.log(oneAway("1234", "123") === true);
    console.log(oneAway("12", "123") === true);
    console.log(oneAway("123", "12") === true);
    console.log(oneAway("123", "163") === true);
    console.log(oneAway("163", "123") === true);
    console.log(oneAway("163", "12345") === false);
    console.log(oneAway("12534", "1234") === true);
    console.log(oneAway("12a3555", "12a455") === false); console.log(oneAway("abc", "1234") === false);
}