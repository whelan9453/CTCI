class Main {
    public static void main(String[] args) {
        // test1
        System.out.println(isU("aaa") == false);
        System.out.println(isU("abc") == true);
        System.out.println(isU("abcA") == true);
        System.out.println(isU("abcAA") == false);
        // test2
        System.out.println(isUnique("aaa") == false);
        System.out.println(isUnique("abc") == true);
        System.out.println(isUnique("abcA") == true);
        System.out.println(isUnique("abcAA") == false);
    }

    // time:O(n), n is input string length
    // space:O(128)=O(1)
    // build a dictionary and check later
    static boolean isU(String str) {
        // Assume this is a ASCII string
        int[] m = new int[128];
        for (int i = 0; i < str.length(); i++) {
            m[str.charAt(i)]++;
            if (m[str.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(String str) {
        // Use bits to check uniqueness
        // GOTCHA: Only valid for 32 bits because bit operator can only manipulate 32
        // bits
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // get char code
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
