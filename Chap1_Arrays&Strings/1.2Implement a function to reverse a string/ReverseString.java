class Main {
    public static void main(String[] args) {
        System.out.println(reverseStr("Hello World!").equals("!dlroW olleH"));
        System.out.println(reverseStr("abcdefgABCDEFG"));
        System.out.println(reverseStr("abcdefg_ABCDEFG"));
        System.out.println(reverseStr("abcdefg . ABCDEFG"));
        System.out.println(reverseStr("中文怎麼樣"));
    }

    // time:O(n/2) = O(n), n is the input string length
    // space:O(1), in place switch
    static String reverseStr(String input) {
        char[] arr = input.toCharArray();
        int l = 0, r = input.length() - 1;
        while (l < r) {
            char temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
        return String.valueOf(arr);
    }
}
