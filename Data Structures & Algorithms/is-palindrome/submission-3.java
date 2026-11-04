class Solution {
    private boolean fine(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while (left <= right && !fine(s.charAt(left))) {
                ++left;
            }
            
            while (left <= right && !fine(s.charAt(right))) {
                --right;
            }

            if (left <= right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            else {
                ++left;
                --right;
            }
        }

        return true;
    }
}
