class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        int prefixSum = 0;
        int res = 0;

        for (int any : nums) {
            prefixSum += any;

            int other = prefixSum - k;
            res += prefixSumCount.getOrDefault(other, 0);

            if (prefixSum == k) {
                res += 1;
            }

            prefixSumCount.put(prefixSum, 1 + prefixSumCount.getOrDefault(prefixSum, 0));
            
        }

        return res;
    }
}