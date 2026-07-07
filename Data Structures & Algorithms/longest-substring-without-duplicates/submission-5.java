class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastI = new int[300];

        Arrays.fill(lastI, -1);
        int res = s.isEmpty() ? 0 : 1;
        int lo = -1;

        for (int move = 0; move < s.length(); ++move) {
            int ci = s.charAt(move);
            if (lastI[ci] >= 0) {
                lo = Math.max(lo, lastI[ci]);                
            }
            res = Math.max(res, move - lo);
            lastI[ci] = move;
        }

        return res;
    }
}
