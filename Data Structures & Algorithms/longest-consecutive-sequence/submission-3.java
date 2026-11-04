class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> seen = new HashSet<>();

        for (int any : nums) seen.add(any);

        Map<Integer, Integer> endingCount = new HashMap<>();

        for (int any : nums) {
            int count = 0;
            int x = any;

            while (seen.contains(x)) {
                if (endingCount.containsKey(x)) {
                    count += endingCount.get(x);
                    break;
                }

                ++count;
                --x;
            }

            endingCount.put(any, count);
            longest = Math.max(longest, count);
        }

        return longest;
    }
}
