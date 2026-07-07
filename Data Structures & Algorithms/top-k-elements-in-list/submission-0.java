class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[2001];

        for (int i = 0; i < nums.length; ++i) {
            count[nums[i] + 1000]++;
        }

        List<Integer> klist = new ArrayList<>();

        for (int i = 0; i < count.length; ++i) {
            if (count[i] > 0) {
                klist.add(i);
            }
        }

        Collections.sort(klist, (a, b) -> count[b] - count[a]);

        int[] ans = new int[k];

        for (int i = 0; i < k; ++i) {
            ans[i] = klist.get(i) - 1000;
        }
        return ans;
    }
}
