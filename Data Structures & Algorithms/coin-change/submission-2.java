class Solution {
    int[][] dp;
    int inf;

    public int coinChange(int[] coins, int amount) {
        inf = amount + 1;
        dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; ++i) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; ++j) {
            dp[0][j] = inf;
        }

        dp[0][0] = inf;

        // int x;
        // return ((x = count(coins, amount, coins.length - 1)) > 10000) ? -1 : x;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - coins[i - 1]], dp[i][j - coins[i - 1]]) + 1);
                }
            }
        }

        return dp[coins.length][amount] == inf ? -1 : dp[coins.length][amount];
    }

    // int count(int[] coins, int amount, int i) {
    //     if (amount == 0) {
    //         return 0;
    //     }

    //     if (i < 0) {
    //         return 10000;
    //     }

    //     if (dp[i] != -1) return dp[i];

    //     int takeThisCoin = amount >= coins[i] ? 1 + count(coins, amount - coins[i], i) : 10000;
    //     int takeThisCoinMove = amount >= coins[i] ? 1 + count(coins, amount - coins[i], i - 1) : 10000;
    //     int doNotTakeThisCoin = count(coins, amount, i - 1);

    //     return Math.min(takeThisCoin, Math.min(takeThisCoinMove, doNotTakeThisCoin));
    // }
}
