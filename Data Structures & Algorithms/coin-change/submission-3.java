class Solution {
    int[][] dp;
    int inf;

    public int coinChange(int[] coins, int amount) {

        // Ask yourself, why?
        inf = amount + 1;

        dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; ++i) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; ++j) {
            dp[0][j] = inf;
        }

        dp[0][0] = inf;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] > j) { // Ask yourself, why?
                    dp[i][j] = dp[i - 1][j];
                } else { // Ask yourself, whats going on here?
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - coins[i - 1]], dp[i][j - coins[i - 1]]) + 1);
                }
            }
        }

        return dp[coins.length][amount] == inf 
            ? -1
            : dp[coins.length][amount];
    }
}
