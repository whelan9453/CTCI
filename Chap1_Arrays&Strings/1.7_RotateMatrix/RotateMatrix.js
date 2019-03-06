/**
 * @param {number[][]} m
 * @returns {number[][]}
 * time:O(n^2), n is the side length of the matrix
 * space:O(n^2)
 */
function rotateMatrixR(m) {
    let n = m.length;
    let ret = new Array(n);
    for (let i = 0; i < n; i++) {
        ret[i] = new Array(n);
    }
    // take a 3x3 matrix as an example (clockwise rotate)
    // i = 0, j = 0,1,2 -> j = 2, i = 0,1,2
    // i = 1, j = 0,1,2 -> j = 1, i = 0,1,2
    // i = 2, j = 0,1,2 -> j = 0, i = 0,1,2
    // find the pattern and copy value to corresponding place
    for (let i = 0; i < n; i++) {
        for (let k = 0; k < n; k++) {
            ret[k][n - i - 1] = m[i][k];
        }
    }
    return ret;
}

/**
 * @param {number[][]} m
 * @returns {number[][]}
 * time:O(n^2), n is the side length of the matrix
 * space:O(n^2)
 */
function rotateMatrixL(m) {
    let n = m.length;
    let ret = new Array(n);
    for (let i = 0; i < n; i++) {
        ret[i] = new Array(n);
    }
    // counter-clockwise sample of a 3x3 matrix
    // i = 0, j = 0,1,2 -> j = 0, i = 2,1,0
    // i = 1; j = 0,1,2 -> j = 1, i = 2,1,0
    // i = 2; j = 0,1,2 -> j = 2, i = 2,1,0
    for (let i = 0; i < n; i++) {
        for (let k = 2; k >= 0; k--) {
            ret[k][i] = m[i][n - k - 1];
        }
    }
    return ret;
}

/**
 * @param {number[][]} m
 * @returns {undefined}
 * time:O(n^2), n is the side length of the matrix
 * space:O(1) in place replacement
 */
function rotateMatrixRi(m) {
    let n = m.length;
    // flip left to right
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < Math.floor(n / 2); j++) {
            let temp = m[i][j];
            m[i][j] = m[i][n - j - 1];
            m[i][n - j - 1] = temp;
        }
    }
    // swap diagnosis
    for (let i = 0; i < n; i++) {
        for (let c = 0; c < n - i - 1; c++) {
            let temp = m[i][c];
            m[i][c] = m[n - c - 1][n - i - 1];
            m[n - c - 1][n - i - 1] = temp;
        }
    }
}

/**
 * @param {number[][]} m
 * @returns {undefined}
 * time:O(n^2), n is the side length of the matrix
 * space:O(1) in place replacement
 */
function rotateMatrixLe(m) {
    let n = m.length;
    // flip upside down
    for (let j = 0; j < n; j++) {
        for (let i = 0; i < Math.floor(n / 2); i++) {
            let temp = m[i][j];
            m[i][j] = m[n - i - 1][j];
            m[n - i - 1][j] = temp;
        }
    }
    // swap diagnosis
    for (let i = 0; i < n; i++) {
        for (let c = 0; c < n - i - 1; c++) {
            let temp = m[i][c];
            m[i][c] = m[n - c - 1][n - i - 1];
            m[n - c - 1][n - i - 1] = temp;
        }
    }
}

function test() {
    let m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    console.log("test rotateR");
    for (let i = 0; i < m.length + 1; i++) {
        m = rotateMatrixR(m);
        console.log(m);
    }
    console.log("test rotateL");
    for (let i = 0; i < m.length + 1; i++) {
        m = rotateMatrixL(m);
        console.log(m);
    }
    console.log("test rotateR in place");
    for (let i = 0; i < m.length + 1; i++) {
        rotateMatrixRi(m);
        console.log(m);
    }
    console.log("test rotateL in place");
    for (let i = 0; i < m.length + 1; i++) {
        rotateMatrixLe(m);
        console.log(m);
    }
}