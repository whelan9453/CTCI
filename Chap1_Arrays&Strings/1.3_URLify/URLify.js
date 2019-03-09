/**
 * @param {string} str
 * @param {number} n
 * @returns {string}
 */
function URLify(str, n) {
    let slow = n - 1;
    let fast = n - 1;
    let tail = true;
    let arr = str.split("");
    while (slow > 0 && fast > 0) {
        while (tail && arr[fast] == " ") {
            fast--;
        }
        tail = false;
        if (arr[fast] !== " ") {
            arr[slow--] = arr[fast--];
        } else {
            arr[slow--] = "0";
            arr[slow--] = "2";
            arr[slow--] = "%";
            fast--;
        }
    }
    return arr.join("");
}

function test() {
    let str = "my name is tony      ";
    console.log(URLify(str, str.length));
}