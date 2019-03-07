/**
 * @param {int[][] m}
 * @returns {undefined}
 * time:O(n*m), n and m is the width and height of the matrix
 * space:O(n+m)
 */
function zeroMatrix(m) {
    // check bounds
    if (m.length < 0 || m[0].length < 0) {
        return;
    }
    let row = new Array(m.length).fill(0);
    let col = new Array(m[0].length).fill(0);
    // traverse and mark zero positions
    for (let i = 0; i < row.length; i++) {
        for (let j = 0; j < col.length; j++) {
            if (m[i][j] === 0) {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
    // traverse and put zeros
    for (let i = 0; i < row.length; i++) {
        for (let j = 0; j < col.length; j++) {
            if (row[i] === 1 || col[j] === 1) {
                m[i][j] = 0;
            }
        }
    }
}

function test() {
    let m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    zeroMatrix(m);
    console.log(m);
    m = [[1, 2, 3], [4, 0, 6], [7, 8, 9]];
    zeroMatrix(m);
    console.log(m);
}