import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // test set 1
        System.out.println(isPermutation("123", "321"));
        // System.out.println(isPermutation("塔滑湯灑湯上塔", "塔塔湯湯上灑滑"));
        System.out.println(isPermutation("abc", "bac"));
        System.out.println(isPermutation("aaa", "aaa"));
        System.out.println(isPermutation("aaa", "bbb"));
        System.out.println(isPermutation("baabba", "bbbaaa"));

        // ---
        System.out.println("---");

        // test set 2
        System.out.println(isPermut("123", "321"));
        System.out.println(isPermut("塔滑湯灑湯上塔", "塔塔湯湯上灑滑"));
        System.out.println(isPermut("abc", "bac"));
        System.out.println(isPermut("aaa", "aaa"));
        System.out.println(isPermut("aaa", "bbb"));
        System.out.println(isPermut("baabba", "bbbaaa"));
    }

    // time: O(n), n is the string length
    // space:O(n), n is the string length
    // build a dictionary and check later
    static boolean isPermutation(String str1, String str2) {
        // Small optimization
        if (str1.length() != str2.length()) {
            return false;
        }
        // Assume it's a ASCII string
        int[] m = new int[128];
        // Do our map for str1
        for (int i = 0; i < str1.length(); i++) {
            m[(int) str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            m[(int) str2.charAt(i)]--;
            if (m[(int) str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    // time:O(nlogn), sorting with string length n
    // space:O(n), two temporary char arrays
    static boolean isPermut(String str1, String str2) {
        // Small optimization
        if (str1.length() != str2.length()) {
            return false;
        }
        // Sort this two arrays and compare one by one
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String sort1 = String.valueOf(arr1);
        String sort2 = String.valueOf(arr2);
        for (int i = 0; i < str1.length(); i++) {
            if (sort1.charAt(i) != sort2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}