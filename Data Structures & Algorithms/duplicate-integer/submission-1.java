class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int any : nums) {
            if (seen.contains(any)) return true;
            seen.add(any);
        }

        return false;
    }
}