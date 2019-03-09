class Main {
    public static void main(String[] args) {
        System.out.println(isRotation("abc", "abc") == true);
        System.out.println(isRotation("abc", "cab") == true);
        System.out.println(isRotation("waterbottle", "bottlewater") == true);
        System.out.println(isRotation("abc", "abcd") == false);
        System.out.println(isRotation("abc", "bca") == true);
        System.out.println(isRotation("abcd", "bdca") == false);
    }

    // time:O(n^2), n is the string length, we loop n times and each time we need time O(n) to copy the string of length n
    // space:O(n), if we count the temp string with length n in the for loop
    // brute force to get all rotations of string 1 and compare with string 2
    static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        for (int i = 0; i < str1.length(); i++) {
            String temp = str1.substring(i + 1) + str1.substring(0, i + 1);
            if (temp.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}