class Main {
    public static void main(String[] args) {
        System.out.println(oneAway("12", "123") == true);
        System.out.println(oneAway("123", "1234") == true);
        System.out.println(oneAway("111", "123") == false);
        System.out.println(oneAway("127", "123") == true);
        System.out.println(oneAway("12abab", "123") == false);
        System.out.println(oneAway("abc", "cba") == false);
        System.out.println(oneAway("abcdefg", "abcdeg") == true);
        System.out.println(oneAway("abcdeg", "abcdefg") == true);
    }

    // time:O(n), n is the longer string length
    // space:O(n), we would use several string copies in this solution
    // break into two situations, which are replace and insert/remove
    // string length will be the same in the replace case
    static boolean oneAway(String str1, String str2) {
        // Small optimization (Check Two or More Away)
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        // check replace
        if (str1.length() == str2.length()) {
            int diff = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                }
            }
        }
        // put longer string to str1
        if (str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        // check insert/remove
        int diff = 0;
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
                // Because str2 is shorter
                j++;
                continue;
            }
            i++;
            j++;
        }
        return true;
    }
}