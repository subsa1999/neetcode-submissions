class Solution {
    public int maxArea(int[] heights) {
        int lo = 0;
        int hi = heights.length - 1;
        int maxWater = 0;

        while (lo < hi) {
            int water = Math.min(heights[lo], heights[hi]) * (hi - lo);
            maxWater = Math.max(water, maxWater);
            if (heights[lo] < heights[hi]) {
                ++lo;
            } else if (heights[lo] > heights[hi]) {
                --hi;
            } else {
                ++lo;
                --hi;
            }
        }

        return maxWater;
    }
}
