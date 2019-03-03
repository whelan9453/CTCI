import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println("test rotateMatrixRight");
        int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(m));
        int[][] m2 = rotateMatrixRight(m);
        System.out.println(Arrays.deepToString(m2));
        int[][] m3 = rotateMatrixRight(m2);
        System.out.println(Arrays.deepToString(m3));
        int[][] m4 = rotateMatrixRight(m3);
        System.out.println(Arrays.deepToString(m4));
        int[][] m5 = rotateMatrixRight(m4);
        System.out.println(Arrays.deepToString(m5));
        System.out.println("test rotateMatrixLeft");
        m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(m));
        m2 = rotateMatrixLeft(m);
        System.out.println(Arrays.deepToString(m2));
        m3 = rotateMatrixLeft(m2);
        System.out.println(Arrays.deepToString(m3));
        m4 = rotateMatrixLeft(m3);
        System.out.println(Arrays.deepToString(m4));
        m5 = rotateMatrixLeft(m4);
        System.out.println(Arrays.deepToString(m5));
    }

    // time:O(n^2), n is the matrix side length
    // space:O(n^2), we create a nxn matrix and copy value to there
    static int[][] rotateMatrixRight(int[][] m) {
        int n = m.length;
        int[][] ret = new int[n][n];
        // take a 3x3 matrix as an example (clockwise rotate)
        // i = 0, j = 0,1,2 -> j = 2, i = 0,1,2
        // i = 1, j = 0,1,2 -> j = 1, i = 0,1,2
        // i = 2, j = 0,1,2 -> j = 0, i = 0,1,2
        // find the pattern and copy value to corresponding place
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                ret[k][n - i - 1] = m[i][k];
            }
        }
        return ret;
    }

    // time:O(n^2), n is matrix side length
    // space:O(n^2), we create a nxn matrix
    static int[][] rotateMatrixLeft(int[][] m) {
        int n = m.length;
        int[][] ret = new int[n][n];
        // counter-clockwise sample of a 3x3 matrix
        // i = 0, j = 0,1,2 -> j = 0, i = 2,1,0
        // i = 1; j = 0,1,2 -> j = 1, i = 2,1,0
        // i = 2; j = 0,1,2 -> j = 2, i = 2,1,0
        for (int i = 0; i < n; i++) {
            for (int k = n - 1; k >= 0; k--) {
                ret[k][i] = m[i][n - k - 1];
            }
        }
        return ret;
    }
}