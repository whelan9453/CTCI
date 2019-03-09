class Main {
    public static void main(String[] args) {
        // part1
        System.out.println(isRotation("abc", "abc") == true);
        System.out.println(isRotation("abc", "cab") == true);
        System.out.println(isRotation("waterbottle", "bottlewater") == true);
        System.out.println(isRotation("abc", "abcd") == false);
        System.out.println(isRotation("abc", "bca") == true);
        System.out.println(isRotation("abcd", "bdca") == false);
        // part2
        System.out.println(isRotationSmart("abc", "abcd") == false);
        System.out.println(isRotationSmart("abc", "bca") == true);
        System.out.println(isRotationSmart("abcd", "bdca") == false);
    }

    // time:O(n^2), n is the string length, we loop n times and each time we need
    // time O(n) to copy the string of length n
    // space:O(n), if we count the temp string with length n in the for loop
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

    // this is a tricky one
    // time:O(2n) = O(n), n is the length of str1
    // space:O(n), we need n more space for a 2n length str1+str1
    // if str1 is x+y, and then str2 is y+x
    // and str2 must be substring of str1+str1 because y+x must be a substring of
    // x+y+x+y
    static boolean isRotationSmart(String str1, String str2) {
        return (str1 + str1).contains(str2);
    }
}