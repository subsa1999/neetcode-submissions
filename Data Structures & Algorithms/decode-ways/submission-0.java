class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        return countDecodings(s, 0, dp);
    }

    int countDecodings(String s, int i, int[] dp) {
        if (i >= s.length()) return 1;

        if (dp[i] != -1) return dp[i];

        if (s.charAt(i) == '0') return dp[i] = 0;


        return dp[i] = (
            countDecodings(s, i + 1, dp) +
            ((i + 1 < s.length()) && (((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26) 
                ? countDecodings(s, i + 2, dp)
                : 0)
        );
    }
}