class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 100000;
        int maxProfit = 0;

        for (int price : prices) {
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
