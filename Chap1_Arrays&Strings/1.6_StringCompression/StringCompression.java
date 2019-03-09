class Main {
    public static void main(String[] args) {
        System.out.println(compressStr("abc").equals("abc"));
        System.out.println(compressStr("aabbccc").equals("a2b2c3"));
        System.out.println(compressStr("abcABC").equals("abcABC"));
        System.out.println(compressStr("abccccABBBBBC").equals("a1b1c4A1B5C1"));
    }

    // time:O(n), n is the string length
    // space:O(n)
    // use StringBuilder to avoid redundant string copy
    // straight forward count repeat chars and compare with the original string
    static String compressStr(String str) {
        // zero check
        if (str.length() < 2) {
            return str;
        }
        int repeat = 1;
        char letter = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                repeat++;
            } else {
                sb.append(letter).append(repeat);
                letter = str.charAt(i);
                repeat = 1;
            }
        }
        // append the last char
        sb.append(letter).append(repeat);
        return sb.length() < str.length() ? sb.toString() : str;
    }
}