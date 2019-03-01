import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println(isPalinPermu("abbaabbaaabb") == true);
        System.out.println(isPalinPermu("cba") == false);
        System.out.println(isPalinPermu("111") == false);
        System.out.println(isPalinPermu("") == true);
        System.out.println(isPalinPermu("_^^_") == true);
    }

    // Build a map and check single char (at most 1 single char is allowed)
    // time:O(n+128) = O(n), n is the string length
    // space:O(128+1) = O(1)
    static boolean isPalinPermu(String str) {
        int oddCnt = 0;
        // Assume it's a ASCII string
        int[] m = new int[128];
        for (int i = 0; i < str.length(); i++) {
            m[(int) str.charAt(i)]++;
        }
        // Check at most 1 char can be odd
        for (int i = 0; i < m.length; i++) {
            if (m[i] % 2 == 1) {
                oddCnt++;
            }
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
    }
}