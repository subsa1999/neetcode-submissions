class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int any : nums) {
            freq.put(any, 1 + freq.getOrDefault(any, 0));
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq
            = new PriorityQueue<>(Comparator.comparingInt(e -> -e.getValue()));

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(e);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
