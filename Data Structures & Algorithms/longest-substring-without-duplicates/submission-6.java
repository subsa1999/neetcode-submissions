class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastseen = new HashMap<>();
        int L = 0;
        int left = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int ls = lastseen.getOrDefault(c, -1);
            left = Math.max(left, ls + 1);
            L = Math.max(L, i - left + 1);
            lastseen.put(c, i);
        }

        return L;
    }
}
