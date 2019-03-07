import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[][] m = new int[][] { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
        zeroMatrix(m);
        System.out.println(Arrays.deepToString(m));
        m = new int[][] { { 0, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        zeroMatrix(m);
        System.out.println(Arrays.deepToString(m));
        m = new int[][] { { 0, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        zeroMatrix(m);
        System.out.println(Arrays.deepToString(m));
        m = new int[][] {};
        zeroMatrix(m);
        System.out.println(Arrays.deepToString(m));
    }

    // time:O(n*m), n and m is the matrix width and height
    // space:O(n*m), we create two maps to record zero points
    static void zeroMatrixFat(int[][] m) {
        // zero check
        if (m.length < 1 || m[0].length < 1) {
            return;
        }
        // traverse matrix and mark zero points
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    row.put(i, 1);
                    col.put(i, 1);
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (row.containsKey(i) || col.containsKey(j)) {
                    m[i][j] = 0;
                }
            }
        }
    }

    // time:O(n*m), n and m is the matrix width and height
    // space:O(n+m)
    static void zeroMatrix(int[][] m) {
        // zero check
        if (m.length < 1 || m[0].length < 1) {
            return;
        }
        // traverse matrix and mark zero points
        int[] row = new int[m.length];
        int[] col = new int[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    row[i] = 1;
                    col[i] = 1;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    m[i][j] = 0;
                }
            }
        }
    }
}