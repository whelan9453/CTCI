/**
 * @param {string} input
 * time:O(n/2) = O(n), n is the input string length
 * space:O(1), in place switch
 */
function reverseStr(input) {
    let l = 0,
        r = input.length - 1;
    let arr = input.split("");
    while (l < r) {
        let temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
        l++;
        r--;
    }
    return arr.join("");
}