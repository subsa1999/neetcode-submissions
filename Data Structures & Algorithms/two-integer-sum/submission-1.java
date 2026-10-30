class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        int i = 0;
        for (int any : nums) {
            int other = target - any;

            if (seen.containsKey(other)) {
                return new int[] {seen.get(other), i};
            }

            seen.put(any, i);
            ++i;
        }

        return null;
    }
}
