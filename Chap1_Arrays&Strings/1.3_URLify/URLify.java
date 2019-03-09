class Main {
    public static void main(String[] args) {
        char[] arr = "Hi Tony Stark    ".toCharArray();
        System.out.println(URLify(arr, arr.length));
    }

    static String URLify(char[] arr, int n) {
        // use two pointers
        // the fast one is for finding chars
        // the slow one is for filling in chars and %20
        int slow = n - 1;
        int fast = n - 1;
        boolean tail = true;
        while (slow > 0 && fast > 0) {
            // try to find the last char of the original string
            while (tail && arr[fast] == ' ') {
                fast--;
            }
            tail = false;
            if (arr[fast] != ' ') {
                arr[slow--] = arr[fast--];
            } else {
                arr[slow--] = '0';
                arr[slow--] = '2';
                arr[slow--] = '%';
                fast--;
            }
        }
        return String.valueOf(arr);
    }
}