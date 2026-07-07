class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = charCounts(s);
        int[] b = charCounts(t);

        return Arrays.equals(a, b);
    }

    int[] charCounts(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        return a;
    }
}
